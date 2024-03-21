package com.learning_management_system;

import java.sql.Connection;
import java.sql.DriverManager;

public class DBConnection {
    
    static final String DB_URL = "jdbc:mysql://localhost/learning_management_system";
    static final String USER = "root";
    static final String PASS = "examly";

    private Connection con = null;

    public Connection getCon() {
        try {
            if(con == null || con.isClosed()) {
                con = DriverManager.getConnection(DB_URL, USER, PASS);
                System.out.println("Database Connection eshteblished");
            } 
        } catch (Exception e) {
            e.printStackTrace();
        }
        return con;
    }

    public void setCon(Connection con) {
        this.con = con;
    }

    public void closeConnection() {
        try {
            if(con != null || con.isClosed()) 
                con.close();
        } catch (Exception e) { e.printStackTrace(); }
        finally { con = null; }
    }
}
