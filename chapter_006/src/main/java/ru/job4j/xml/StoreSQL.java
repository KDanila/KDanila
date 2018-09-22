package ru.job4j.xml;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;
import ru.job4j.tracker.Settings;

import java.sql.*;

public class StoreSQL {
    /**
     * Settings.
     */
    private Settings set = new Settings("C:\\Projects\\KDanila\\chapter_006\\src\\main\\java\\ru\\job4j\\xml\\config.properties");
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
    private static final Logger log = LoggerFactory.getLogger(SQLException.class);

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
     */
    void connectingToDB() {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (this.conn == null) {
                try {
                    this.conn.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
        if (this.checkTableInDB()) {
            deleteTableInDb();
        }
        this.createTableInDB();
    }

    private void deleteTableInDb() {
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeQuery("DROP TABLE entry ");
            st.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
    }

    /**
     * createTableInDB method.
     * <p>
     * Creating table in database, if it's doesn't exist.
     */
    private void createTableInDB() {
        Statement st = null;
        try {
            st = conn.createStatement();
            st.executeQuery("CREATE TABLE entry (field integer)");
            st.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
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
                if (rs.getString("tablename").equals(dbTableName)) {
                    return true;
                }
            }
            rs.close();
            st.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        }
        return isExist;
    }

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
