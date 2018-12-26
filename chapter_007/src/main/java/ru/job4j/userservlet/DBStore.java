package ru.job4j.userservlet;

import java.io.*;
import java.sql.*;
import java.util.*;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBStore implements Store<User> {

    private static final BasicDataSource SOURCE = new BasicDataSource();

    private static DBStore INSTANCE = new DBStore();

    private static final Logger LOGGER = LoggerFactory.getLogger(DBStore.class);

    private Properties property = new Properties();

    private String dbTableName;
    private String dbName;
    private String name;
    private String password;

    private DBStore() {
        try (InputStream resStream = getClass().getClassLoader().getResourceAsStream(
                "configDbStore.properties")) {
            property.load(resStream);
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        SOURCE.setDriverClassName(property.getProperty("jdbc.driver"));
        SOURCE.setUrl(property.getProperty("jdbc.url"));
        SOURCE.setUsername(property.getProperty("jdbc.username"));
        SOURCE.setPassword(property.getProperty("jdbc.password"));
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        this.dbTableName = property.getProperty("jdbc.tablename");
        this.dbName = property.getProperty("jdbc.DBname");
        this.name = property.getProperty("jdbc.username");
        this.password = property.getProperty("jdbc.password");
        initDataBase();
    }

    private void initDataBase() {
        /*try {
            this.connection = SOURCE.getConnection();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.connection == null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }*/
//        if (!checkDB()) {
//            createDB();
//        }
//        if (!checkTableInDB()) {
//            createTableInDB();
//        }
    }


    public static DBStore getInstance() {
        return INSTANCE;
    }

    public Connection getConnection() {
        Connection connection = null;
        try {
            connection = SOURCE.getConnection();
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return connection;
    }

    @Override
    public boolean add(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into tracker values(?,?,?)")) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }
//todo
    @Override
    public boolean update(String id, User user) {
        return false;
    }

/*
    public boolean update(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("update ? set name=?,email =? where id = ?")) {
            ps.setString(1, dbTableName);
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setInt(4, user.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }
*/

    @Override
    public boolean delete(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from ? where id=?")) {
            ps.setString(1, dbTableName);
            ps.setInt(2, user.getId());
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public Map<Integer, User> findAll() {
        Map<Integer, User> toReturn = new HashMap<>();
        User temp = null;
        int idUser;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT*FROM ?")) {
            ps.setString(1, dbTableName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                temp = new User.UserBuilder(rs.getString("name"))
                        .email(rs.getString("email"))
                        .build();
                idUser = Integer.parseInt(rs.getString("id"));
                temp.setId(idUser);
                toReturn.put(idUser, temp);
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return toReturn;
    }

    @Override
    public User findById(int id) {
        User toReturn = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT*FROM ?")) {
            ps.setString(1, dbTableName);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTemp = rs.getInt("id");
                if (idTemp == id) {
                    toReturn = new User.UserBuilder(rs.getString("name"))
                            .email(rs.getString("email"))
                            .build();
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        toReturn.setId(id);
        return toReturn;
    }
//todo
    @Override
    public boolean isAccessAllowed(String login, String password) {
        return false;
    }
//todo
    @Override
    public User findByLogin(String login) {
        return null;
    }

    /**
     * createTableInDB method.
     * <p>
     * Creating table in database, if it's doesn't exist.
     */
    private void createTableInDB() {
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()) {
            st.executeQuery("CREATE TABLE tracker ( id integer primary key,"
                            + "name varchar(15), "
                            + "email varchar(50),"
                    //                 + "expired_date timestamp)");
            );
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }

    /**
     * checkTableInDB method.
     * <p>
     * checking table in database.
     *
     * @return true if db existing.
     */
    private boolean checkTableInDB() {
        boolean isExist = false;
        try (Connection connection = SOURCE.getConnection()) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pg_catalog.pg_tables;");
            while (rs.next()) {
                if (rs.getString("tablename").equals(dbTableName)) {
                    return true;
                }
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isExist;
    }

    /**
     * creatDB method.
     */
    private void createDB() {
        Statement st = null;
        try (Connection connection = SOURCE.getConnection()) {
            st = connection.createStatement();
            st.executeQuery("CREATE DATABASE trackerdb");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * checkDB method.
     *
     * @return true if DB is existing.
     */
    //todo UnsupportedOperationException: Not supported by BasicDataSource  ---> correct.
    private boolean checkDB() {
        boolean isExist = false;
        try (Connection connection = SOURCE.getConnection(name, password)) {
            Statement st = connection.createStatement();
            ResultSet rs = st.executeQuery("SELECT datname FROM pg_database");
            while (rs.next()) {
                if (rs.getString("datname").equals(dbName)) {
                    return true;
                }
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isExist;
    }
}

