package com.learning_management_system;

public class App {
    
    static final String DB_URL = "jdbc:mysql://localhost/learning_management_system";
    static final String USER = "root";
    static final String PASS = "examly";
    
    public static void main( String[] args ) {
        DBManagement dbManagement = new DBManagement();

        System.out.println("Which way you want to enter the questions: ");
    }
}
