package ru.job4j.userservlet;

import java.io.IOException;
import java.io.InputStream;
import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.HashMap;
import java.util.Map;
import java.util.Properties;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBStore implements Store<User>, AutoCloseable {

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
        if (!checkTableInDB()) {
            createTableInDB();
        }
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

    /*
    id name email login password
     */
    @Override
    public boolean add(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("insert into " + dbTableName + " values(?,?,?,?,?)")) {
            ps.setInt(1, user.getId());
            ps.setString(2, user.getName());
            ps.setString(3, user.getEmail());
            ps.setString(4, user.getLogin());
            ps.setString(5, user.getPassword());
            ps.executeUpdate();
            return true;
        } catch (Exception e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }

    /*
    id name email login password
     *///todo
    @Override
    public boolean update(String id, User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("update " + dbTableName +
                     " set name=?,email =?, login = ?, password = ? where id = ?")) {
            ps.setString(1, user.getName());
            ps.setString(2, user.getEmail());
            ps.setString(3, user.getLogin());
            ps.setString(4, user.getPassword());
            ps.setInt(5, Integer.valueOf(id));
            ps.executeUpdate();
            return true;
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return false;
    }

    @Override
    public boolean delete(User user) {
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("delete from " + dbTableName + " where id=?")) {
            ps.setInt(1, user.getId());
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
             PreparedStatement ps = connection.prepareStatement("SELECT*FROM " + dbTableName)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                idUser = rs.getInt("id");
                temp = new User.UserBuilder(rs.getString("name"))
                        .email(rs.getString("email"))
                        .login(rs.getString("login"))
                        .password(rs.getString("password"))
                        .build();
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
             PreparedStatement ps = connection.prepareStatement("SELECT * FROM " + dbTableName + " where id=?")) {
            ps.setInt(1, id);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                toReturn = new User.UserBuilder(rs.getString("name"))
                        .email(rs.getString("email"))
                        .login(rs.getString("login"))
                        .password(rs.getString("password"))
                        .build();
                toReturn.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        toReturn.setId(id);
        return toReturn;
    }

    @Override
    public boolean isAccessAllowed(String login, String password) {
        String tempLogin;
        String tempPassword;
        boolean isAllowed = false;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT*FROM " + dbTableName)) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                tempLogin = rs.getString("login");
                if (tempLogin.equals(login)) {
                    tempPassword = rs.getString("password");
                    if (tempPassword.equals(password)) {
                        isAllowed = true;
                        break;
                    }
                    break;
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isAllowed;
    }


    @Override
    public User findByLogin(String login){
        User toReturn = null;
        try (Connection connection = SOURCE.getConnection();
             PreparedStatement ps = connection.prepareStatement("SELECT*FROM " + dbTableName+ " WHERE LOGIN = ?")) {
            ps.setString(1,login);
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                toReturn = new User.UserBuilder(rs.getString("name"))
                        .email(rs.getString("email"))
                        .login(rs.getString("login"))
                        .password(rs.getString("password"))
                        .build();
                toReturn.setId(rs.getInt("id"));
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return toReturn;
    }

    /**
     * createTableInDB method.
     * <p>
     * Creating table in database, if it's doesn't exist.
     */
    void createTableInDB() {
        try (Connection connection = SOURCE.getConnection()) {
            PreparedStatement ps = connection.prepareStatement("CREATE TABLE " + this.dbTableName + " ( id integer primary key,\n" +
                    "                            name varchar(15), \n" +
                    "                            email varchar(50),\n" +
                    "                            login varchar(50),\n" +
                    "                            password varchar(50))");
            ps.executeUpdate();
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
    boolean checkTableInDB() {
        boolean isExist = false;
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.createStatement()) {
            ResultSet rs = st.executeQuery("SELECT * FROM pg_catalog.pg_tables;");
            while (rs.next()) {
                if (rs.getString("tablename").equals(dbTableName)) {
                    isExist = true;
                    break;
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isExist;
    }

    //todo
    @Override
    public void close() throws Exception {

    }

    /**
     * creatDB method.
     */
/*    private void createDB() {
        Statement st = null;
        try (Connection connection = SOURCE.getConnection()) {
            st = connection.createStatement();
            st.executeQuery("CREATE DATABASE trackerdb");
            st.close();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }*/

    /**
     * checkDB method.
     *
     * @return true if DB is existing.
     */
  /*    private boolean checkDB() {
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
    }*/
}

