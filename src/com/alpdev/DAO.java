package com.alpdev;

import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.SQLException;
import java.sql.Statement;

//Database access class
public class DAO {

    private String dbUrl;
    private String user;
    private String pass;
    private Connection connection = null;
    private Statement statement = null;

    public String getdbUrl() {
        return dbUrl;
    }

    public void setdbUrl(String dbUrl) {
        this.dbUrl = dbUrl;
    }

    public String getUser() {
        return user;
    }

    public void setUser(String user) {
        this.user = user;
    }

    public String getPass() {
        return pass;
    }

    public void setPass(String pass) {
        this.pass = pass;
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

    public void getConntection () {
        try {
            connection = DriverManager
                    .getConnection(dbUrl, user, pass);

        } catch (
                SQLException e) {
            System.out.println("Connection Failed");
            e.printStackTrace();
        }

        if (connection != null) {
            System.out.println("You successfully connected to database now");
        } else {
            System.out.println("Failed to make connection to database");
        }
    }

    public void connect2DB () {
        if (this.test_JDBC_Conntection()) {
            this.getConntection();
        }
    }
}
