package com.learning_management_system;

import java.sql.Connection;
import java.sql.PreparedStatement;
import java.sql.SQLException;

public class DBManagement {
    
    private DBConnection dbConnection = new DBConnection();
    private Connection con = dbConnection.getCon();

    DBManagement() {
        String createQuizTableQuery = "CREATE TABLE IF NOT EXISTS quiz (id INT AUTO_INCREMENT NOT NULL, name VARCHAR(40) NOT NULL, start_date_time DATETIME NOT NULL, buffer_time INT, duration INT NOT NULL, questions VARCHAR(4000) NOT NULL ,PRIMARY KEY (id));";

        String createAnswerTableQuery = "CREATE TABLE IF NOT EXISTS answer (id INT AUTO_INCREMENT NOT NULL, quiz_id INT NOT NULL, answer VARCHAR(3000), PRIMARY KEY (id));";

        try {
            PreparedStatement createTable = con.prepareStatement(createQuizTableQuery);
            createTable.executeUpdate();
            createTable = con.prepareStatement(createAnswerTableQuery);
            createTable.executeUpdate();
        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}
