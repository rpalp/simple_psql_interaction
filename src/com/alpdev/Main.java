package com.alpdev;


import java.sql.Connection;


public class Main {

    //  Database credentials

    public static void main(String[] args) {
        DAO mydb = new DAO();
        mydb.setdbUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        mydb.setUser("postgres");
        mydb.setPass("mysecretpassword");

        mydb.connect2DB();

    }
}

