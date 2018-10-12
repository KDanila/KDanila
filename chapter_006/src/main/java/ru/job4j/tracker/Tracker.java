package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;
import java.util.ArrayList;
import java.util.List;

/**
 * Tracker класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Tracker {
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
    private final String dbTableName = "tracker";

    /**
     * Connecting to DB method.
     */
    void connectingToDB() {
        try {
            this.conn = DriverManager.getConnection(url, username, password);
        } catch (SQLException e) {
            LOGGER.error(e.getMessage(), e);
        } finally {
            if (this.conn == null) {
                try {
                    this.conn.close();
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

    /**
     * Метод public Item add(Item) добавляет заявку, переданную в аргументах в массив заявок this.items.
     *
     * @param item - заявка.
     */
    public void add(Item item) {
        try (PreparedStatement ps = conn.prepareStatement("insert into tracker values(?,?,?,?)")) {
            ps.setInt(1, item.getId());
            ps.setString(2, item.getName());
            ps.setString(3, item.getDescription());
            ps.setTimestamp(4, item.getCreateTime());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * Method update(Item).
     *
     * @param item - текущая заявка.
     */
    public void update(Item item) {
        try (PreparedStatement ps = conn.prepareStatement("update tracker set name=?,description =?,expired_date =?"
                + " where id = ?")) {
            ps.setString(1, item.getName());
            ps.setString(2, item.getDescription());
            ps.setTimestamp(3, item.getCreateTime());
            ps.setInt(4, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }


    /**
     * Метод public void delete(Item) должен удалить ячейку из базы.
     *
     * @param item - заявка.
     */
    public void delete(Item item) {
        try (PreparedStatement ps = conn.prepareStatement("delete from tracker where id=?")) {
            ps.setInt(1, item.getId());
            ps.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }

    /**
     * findAll() method.
     * <p>
     * return Item[] from database.
     *
     * @return массив item без пустых элементов.
     */
    public Item[] findAll() {
        List<Item> toReturn = new ArrayList<Item>();
        try (PreparedStatement ps = conn.prepareStatement("SELECT*FROM tracker")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                toReturn.add(new Item(rs.getInt("id"), rs.getString("name"),
                        rs.getString("description"), rs.getTimestamp("expired_date")));
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn.toArray(new Item[toReturn.size()]);
    }

    /**
     * findByName method.
     *
     * @param key - имя заявки
     * @return item - заявка
     */
    public Item findByName(String key) {
        Item toReturn = null;
        try (PreparedStatement ps = conn.prepareStatement("SELECT*FROM tracker")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                String name = rs.getString("name");
                if (name.equals(key)) {
                    toReturn = new Item(rs.getInt("id"), name,
                            rs.getString("description"), rs.getTimestamp("expired_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
    }

    /**
     * findById method.
     *
     * @param id - требуемый id.
     * @return item - искомая завяка.
     */
    public Item findById(int id) {
        Item toReturn = null;
        try (PreparedStatement ps = conn.prepareStatement("SELECT*FROM tracker")) {
            ResultSet rs = ps.executeQuery();
            while (rs.next()) {
                int idTemp = rs.getInt("id");
                if (idTemp == id) {
                    toReturn = new Item(idTemp, rs.getString("name"),
                            rs.getString("description"), rs.getTimestamp("expired_date"));
                }
            }
        } catch (SQLException e) {
            e.printStackTrace();
        }
        return toReturn;
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
            st = conn.createStatement();
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
            Statement st = conn.createStatement();
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