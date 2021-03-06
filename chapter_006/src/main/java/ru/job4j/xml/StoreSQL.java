package ru.job4j.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.Settings;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Savepoint;
import java.sql.Statement;


/**
 * StoreSQL class.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class StoreSQL {
    /**
     * Settings.
     */
    private Settings set = new Settings("chapter_006/src/main/resource/configTracker.properties");
    /**
     * url.
     */
    private String url = set.getUrl();
    /**
     * username.
     */
    private String username = set.getLogin();
    /**
     * password.
     */
    private String password = set.getPassword();
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
    private final String dbName = "trackerdb";
    /**
     * Name of table.
     */
    private final String dbTableName = "entry";

    /**
     * Connecting to DB method.
     * <p>
     * Create new table in any occasion. If table already exist method
     * delete it and create new. AutoCommit is disabled.
     *
     * @throws SQLException - sqlex.
     */
    void connectingToDB() throws SQLException {
        try (Connection conn = DriverManager.getConnection(url, username, password)) {
            Savepoint save = conn.setSavepoint();
            this.conn = conn;
            this.conn.setAutoCommit(false);
            if (this.checkTableInDB()) {
                deleteTableInDb();
            }
            this.createTableInDB();
            if (checkTableInDB()) {
                conn.rollback();
            }
            this.conn.commit();
        } catch (SQLException e) {
            this.conn.rollback();
            LOGGER.error(e.getMessage(), e);
        }
    }


    /**
     * deleteTableInDB.
     */
    private void deleteTableInDb() {
        try (Statement st = conn.createStatement()) {
            st.executeQuery("DROP TABLE entry ");
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
        try (Statement st = conn.createStatement()) {
            st.executeQuery("CREATE TABLE entry (field integer)");
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
                if (rs.getString("tablename").equals(dbTableName)) {
                    return true;
                }
            }
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        }
        return isExist;
    }

    /**
     * generate method.
     *
     * @param n - number of values to insert.
     */
    public void generate(int n) {
        for (int i = 0; i < n; i++) {
            try (PreparedStatement ps = conn.prepareStatement("insert into entry values(?)")) {
                ps.setInt(1, i);
                ps.executeUpdate();
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
    }
}
