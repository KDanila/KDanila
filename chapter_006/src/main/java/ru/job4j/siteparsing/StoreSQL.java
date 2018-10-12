package ru.job4j.siteparsing;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.io.FileInputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.sql.Timestamp;
import java.util.Properties;


/**
 * StoreSQL class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StoreSQL implements AutoCloseable {
    /**
     * Settings.
     */
    private final Properties settings = new Properties();
    /**
     * url.
     */
    private final String url;
    /**
     * username.
     */
    private final String username;
    /**
     * password.
     */
    private final String password;
    /**
     * table name.
     */
    private final String tablename;
    /**
     * connection.
     */
    private Connection conn = null;
    /**
     * Logger.
     */
    private static final Logger LOGGER = LoggerFactory.getLogger(SQLException.class);
    /**
     * name of database.
     */
    private final String dbName;

    /**
     * Constructor.
     *
     * @param path - properties.
     */
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
        this.dbName = settings.getProperty("jdbc.tablename");
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
            String request = "CREATE TABLE " + this.tablename + " (id serial,\n"
                    + "                Thema text,\n"
                    + "                Author text,\n"
                    + "                Answer text,\n"
                    + "                Views Integer,\n"
                    + "                data TimeStamp )";
            ResultSet rs = st.executeQuery(request);
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
        try (Statement st = conn.createStatement();
             ResultSet rs = st.executeQuery("SELECT * FROM pg_catalog.pg_tables;")) {
            while (rs.next()) {
                if (rs.getString("tablename").equals(this.tablename)) {
                    isExist = true;
                    break;
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isExist;
    }

    /**
     * Insert method.
     *
     * @param thema - thema.
     * @param author - author.
     * @param answer - answer.
     * @param views - views.
     * @param data - data.
     * @throws SQLException - sqlex.
     */
    public void insert(String thema, String author, String answer, int views, Timestamp data) throws SQLException {
        this.conn.setAutoCommit(false);
        //this.conn.setSavepoint();
        String request = "insert into sql_ru (thema,author,answer,views,data) values(?,?,?,?,?)";
        try (PreparedStatement ps = conn.prepareStatement(request)) {
            ps.setString(1, thema);
            ps.setString(2, author);
            ps.setString(3, answer);
            ps.setInt(4, views);
            ps.setTimestamp(5, data);
            ps.executeUpdate();
            this.conn.commit();
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
            this.conn.rollback();
        }
    }

    /**
     * Get Last Date from sql database.
     *
     * @return LastVacancyDate
     */
    public Timestamp getLastDate() {
        Timestamp lastDate = null;
        String request = "select max(data) from " + this.tablename;
        try (Statement st = this.conn.createStatement()) {
            try (ResultSet rs = st.executeQuery(request)) {
                if (rs != null) {
                    while (rs.next()) {
                        lastDate = rs.getTimestamp("max");
                    }
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return lastDate;
    }

    /**
     * AutoClosable.
     *
     * @throws Exception - e.
     */
    @Override
    public void close() throws Exception {
        this.conn.close();
    }
}

