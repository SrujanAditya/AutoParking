package com.epam.rdtraining.databasedao;

import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.util.Properties;

/**
 * @author Srujan_Aditya
 *
 */
public final class DBConnect {
    /**
     * reference instance of the class.
     */
    private static DBConnect dbinstance;
    /**
     * Connection variable.
     */
    private Connection con;
    /**
     * private constructor.
     */
    private DBConnect() { }
    /**
     * strings to store driver host,username and password regarding database connection.
     */
    private static String host, username, password;
    static {
        Properties prop = new Properties();
        try {
            prop.load(DBConnect.class.getResourceAsStream("/AutoParking.properties"));
        } catch (IOException e) {
            e.printStackTrace();
        }
        host = prop.getProperty("Host");
        username = prop.getProperty("username");
        password = prop.getProperty("password");
    }
    /**
     * Method to get the instance of this class.
     * @return DBConnect instance
     */
    public static synchronized DBConnect getInstance() {
        if (dbinstance == null) {
            dbinstance = new DBConnect();
        }
        return dbinstance;
    }
    /**
     * Method to get the instance of this class.
     * @return Connection instance
     */
    public Connection getDBConnection() {
        if (con == null) {
            try {
                con = DriverManager.getConnection(host, username, password);
            } catch (SQLException e) {
                e.printStackTrace();
            }
        }
        return con;
    }
    /**
     * main to test.
     * @param args args
     * @throws SQLException sql exception
     */
    public static void main(final String[] args) throws SQLException {
        dbinstance = DBConnect.getInstance();
        Connection c = dbinstance.getDBConnection();
        System.out.println(c);
        c.close();
    }
}
