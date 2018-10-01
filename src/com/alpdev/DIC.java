package com.alpdev;

import java.sql.ResultSet;
import java.sql.SQLException;
import java.sql.Statement;

//Database interaction class
public class DIC extends DAO {


    // Table = "test_user_list";
    // Columns = "user_id", "givenName", "surName", "age"

    public void getDataFromDB () {
        String selectTableSQL = "SELECT * from test_user_list";

        try {
            Statement statement = getStatement();
            ResultSet rs = statement.executeQuery(selectTableSQL);
            while (rs.next()) {
                int user_id = rs.getInt("user_id");
                String givenName = rs.getString("givenName");
                String surName = rs.getString("surName");
                int age = rs.getInt("age");

                System.out.print("user_id " + user_id);
                System.out.print(", " + givenName);
                System.out.print(" " + surName);
                System.out.println(", age " + age + ".");
            }
        } catch (SQLException e) {
                System.out.println("Statement query Failed");
                e.printStackTrace();
        }


    }

    public void setDataToDB (String name, String surName, int age) {
        String insertTableSQL = "INSERT INTO test_user_list(givenName, surName, age) VALUES('" + name + "', '" + surName + "', " + age + ")";
        try {
            Statement statement = getStatement();
            int result = statement.executeUpdate(insertTableSQL);
            System.out.println(result + " row(s) has been added.");
        } catch (SQLException e) {
            System.out.println("Statement query Failed");
            e.printStackTrace();
        }



    }
}
