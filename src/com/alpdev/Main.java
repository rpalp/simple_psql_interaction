package com.alpdev;


public class Main {

    //  Database credentials

    public static void main(String[] args) {
        DIC mydb = new DIC();
        mydb.setdbUrl("jdbc:postgresql://127.0.0.1:5432/postgres");
        mydb.setUser("postgres");
        mydb.setPass("mysecretpassword");

        mydb.connect2DB();
        mydb.setDataToDB("Fedor", "Filatov", 33);
        mydb.getDataFromDB();
    }
}

