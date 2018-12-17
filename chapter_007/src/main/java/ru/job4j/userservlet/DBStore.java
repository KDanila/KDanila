package ru.job4j.userservlet;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.util.Map;

import java.sql.Connection;
import java.sql.Statement;

import org.apache.commons.dbcp2.BasicDataSource;
import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

public class DBStore implements Store<User> {

    private static final BasicDataSource SOURCE = new BasicDataSource();

    private static DBStore INSTANCE = new DBStore();

    private Connection connection = null;

    private static final Logger LOGGER = LoggerFactory.getLogger(SQLException.class);



    public DBStore() {
        SOURCE.setUrl("jdbc:postgresql://localhost:5432/UsersServletDB");
        SOURCE.setUsername("postgres");
        SOURCE.setPassword("6799963");
        SOURCE.setMinIdle(5);
        SOURCE.setMaxIdle(10);
        SOURCE.setMaxOpenPreparedStatements(100);
        initDataBase();
    }

    private void initDataBase() {
        try {
            this.connection = SOURCE.getConnection();
        }        catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.connection == null) {
                try {
                    this.connection.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
        if (!checkDB()) {
            createDB();
        }
        if (!checkTableInDB()) {
            createTableInDB();
        }
    }
    }

    public static DBStore getInstance() {
        return INSTANCE;
    }

    @Override
    public boolean add(User user) {
        try (Connection connection = SOURCE.getConnection();
             Statement st = connection.prepareStatement("...")
        ) {

        } catch (Exception e) {
            e.printStackTrace();
        }
        return true;
    }

    @Override
    public boolean update(User user) {
        return false;
    }

    @Override
    public boolean delete(User user) {
        return false;
    }

    @Override
    public Map<Integer, User> findAll() {
        return null;
    }

    @Override
    public User findById(int id) {
        return null;
    }

    /**
     * createTableInDB method.
     * <p>
     * Creating table in database, if it's doesn't exist.
     */
    private void createTableInDB() {
        Statement st = null;
        try {
            st = connection.createStatement();
            //todo change this shit
            st.executeQuery("CREATE TABLE tracker ( id integer primary key,"
                    + "name varchar(15), "
                    + "description varchar(50),"
                    + "expired_date timestamp)");
            st.close();
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
        try {
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
        try {
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
    private boolean checkDB() {
        boolean isExist = false;
        try {
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

