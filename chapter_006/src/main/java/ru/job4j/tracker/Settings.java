package ru.job4j.tracker;

import java.io.File;
import java.io.FileInputStream;
import java.io.IOException;
import java.util.Properties;

/**
 * Settings класс.
 *
 * @author Kuzmin Danila (mailto:bus1d0@mail.ru)
 * @version $Id$
 * @since 0.1
 */
public class Settings {
    /**
     * FileInputStream.
     */
    private FileInputStream fis;
    /**
     * property.
     */
    private Properties property = new Properties();
    /**
     * url.
     */
    private String url;
    /**
     * login.
     */
    private String login;
    /**
     * password.
     */
    private String password;

    /**
     * Constructor.
     *
     * @param path - string.
     */
    public Settings(String path) {
        try {
            File file = new File(path);
            fis = new FileInputStream(file.getAbsolutePath());
            property.load(fis);
            this.url = property.getProperty("jdbc.url");
            this.login = property.getProperty("username");
            this.password = property.getProperty("password");
        } catch (IOException e) {
            System.out.println(e.getMessage());
        } finally {
            try {
                fis.close();
            } catch (IOException e) {
                e.printStackTrace();
            }
        }
    }

    /**
     * Getter.
     *
     * @return url.
     */
    public String getUrl() {
        return url;
    }

    /**
     * Getter.
     *
     * @return login.
     */
    public String getLogin() {
        return login;
    }

    /**
     * Getter.
     *
     * @return pasword.
     */
    public String getPassword() {
        return password;
    }

}