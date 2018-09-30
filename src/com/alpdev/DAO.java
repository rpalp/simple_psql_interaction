package com.alpdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;



public class DAO {

    private static String dbUrl;
    private static String user;
    private static String pass;
    private Connection connection = null;

    public String getdbUrl() {
        return dbUrl;
    }

    public void setdbUrl(String dbUrl) {
        DAO.dbUrl = dbUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        DAO.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        DAO.pass = pass;
    }



    public boolean test_JDBC_Conntection () {
        System.out.println("Testing connection to PostgreSQL JDBC");

        try {
            Class.forName("org.postgresql.Driver");
        } catch (ClassNotFoundException e) {
            System.out.println("PostgreSQL JDBC Driver is not found. Include it in your library path ");
            e.printStackTrace();
            return false;
        }

        System.out.println("PostgreSQL JDBC Driver successfully connected");
        return true;
    }

    public void conntect2DB () {
        try {
            connection = DriverManager
                    .getConnection(dbUrl, user, pass);

        } catch (
                SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
            return;
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }
}
