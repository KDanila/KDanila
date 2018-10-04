package ru.job4j.siteparsing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.*;
import java.util.Properties;


/**
 * StoreSQL class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class
StoreSQL {
    /**
     * Settings.
     */
    //
    private Properties settings = new Properties();
    /**
     * url.
     */
    private String url;
    /**
     * username.
     */
    private String username;
    /**
     * password.
     */
    private String password;
    /**
     * table name.
     */
    private String tablename;
    /**
     * Connection. toDB.
     */
    private Connection conn = null;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SQLException.class);
    /**
     * Name of database.
     */
    private final String dbName;

    public StoreSQL(String path) {
        try {
            settings.load(new FileInputStream(path));
        } catch (IOException e) {
            LOGGER.error(e.getMessage(), e);
        }
        this.url = settings.getProperty("jdbc.url");
        this.username = settings.getProperty("jdbc.username");
        this.password = settings.getProperty("jdbc.password");
        this.tablename = settings.getProperty("jdbc.tablename");
        this.dbName = settings.getProperty("jdbc.DBname");
    }

    /**
     * Connecting to DB method.
     * <p>
     * Create new table in any occasion. If table already exist method
     * delete it and create new. AutoCommit is disabled.
     */
    void connectingToDB() {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
            if (!this.checkTableInDB()) {
                this.createTableInDB();
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.conn != null) {
                try {
                    this.conn.close();
                } catch (SQLException e) {
                    LOGGER.error(e.getMessage(), e);
                }
            }
        }
    }

    /**
     * createTableInDB method.
     * <p>
     * Creating table in database, if it's doesn't exist.
     */
    private void createTableInDB() {
        try {
            Statement st = conn.createStatement();
            String request = "CREATE TABLE "+this.tablename+" (id serial,\n" +
                    "                Thema VARCHAR(30),\n" +
                    "                Author VARCHAR(30),\n" +
                    "                Answer VARCHAR(30),\n" +
                    "                Views Integer,\n" +
                    "                Data VARCHAR(20))";
            ResultSet rs = st.executeQuery(request);
        }catch (SQLException e) {
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
            Statement st = conn.createStatement();
            ResultSet rs = st.executeQuery("SELECT * FROM pg_catalog.pg_tables;");
            while (rs.next()) {
                if (rs.getString("tablename").equals(this.tablename)) {
                    isExist = true;
                    break;
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
     * generate method.
     */
    public void insert(String thema, String author, String answer, int views, String data) {
        String request = "insert into sql_ru (thema,author,answer,views,data) values(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(request)) {
            ps.setString(1, thema);
            ps.setString(2, author);
            ps.setString(3, answer);
            ps.setInt(4, views);
            ps.setString(5, data);
            ps.executeUpdate();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
    }
}

