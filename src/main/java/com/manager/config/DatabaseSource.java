package com.manager.config;

import java.sql.Connection;
import java.sql.DriverManager;

public class DatabaseSource {
    private static String DB_URL = "jdbc:mysql://localhost:3306/managerhotel";
    private static String USER_NAME = "root";
    private static String PASSWORD = "1234";

    public static Connection openConnect() {
        Connection conn = null;
        try {
            Class.forName("com.mysql.jdbc.Driver");
            conn = DriverManager.getConnection(DB_URL,USER_NAME,PASSWORD);
            System.out.println("connect database success");
        } catch (Exception e) {
            e.printStackTrace();
        }
        return conn;
    }
}
