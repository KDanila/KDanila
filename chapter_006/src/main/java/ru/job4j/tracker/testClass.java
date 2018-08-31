/*package ru.job4j.tracker;

import org.slf4j.Logger;
import org.slf4j.LoggerFactory;

import java.sql.*;

public class testClass implements AutoCloseable {

    private static final Logger log = LoggerFactory.getLogger(SQLException.class);

    public static void main(String[] args) {
        String url = "jdbc:postgresql://localhost:5432/umlclient";
        String username = "postgres";
        String password = "6799963";
        Connection conn = null;
        try {
            conn = DriverManager.getConnection(url, username, password);
            //Statement st = conn.createStatement(); --1 Не динамическая версия
            //ResultSet rs = st.executeQuery("SELECT * FROM auto"); --1
            /* Так делаем запрос из базы executeQuery
            PreparedStatement ps = conn.prepareStatement("SELECT*FROM auto a WHERE name in(?,?,?)");
            ps.setString(1,"bmw");
            ps.setString(2,"mercedes");
            ps.setString(3,"audi");
            ResultSet rs = ps.executeQuery();
            while (rs.next())
            {
            //    System.out.println(String.format("%d,%s",rs.getInt("id"),rs.getString("name"))); --1
               System.out.println(String.format("%d,%s",rs.getInt("id"),rs.getString("name")));
            }*/
         /*   PreparedStatement ps = conn.prepareStatement("INSERT INTO auto VALUES(?,?,?,?,?)");
            //insert into auto values            --(1,'bmw',4,1,3),
            ps.setInt(1,9);
            ps.setString(2,"skoda");
            ps.setInt(3,2);
            ps.setInt(4,2);
            ps.setInt(5,2);
            int rs = ps.executeUpdate();//!!! При вставке
            //rs.close();
            ps.close();
        } catch (SQLException e) {
            log.error(e.getMessage(), e);
        } finally {
            if (conn != null) {
                try {
                    conn.close();
                } catch (SQLException e) {
                    log.error(e.getMessage(), e);
                }
            }
        }
    }

    @Override
    public void close() throws Exception {

    }
}
*/