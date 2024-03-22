package com.learning_management_system;

import java.io.BufferedReader;
import java.io.FileReader;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

public class CsvToSqlServer {
    public static void main(String[] args) {
        String csvFilePath = "path_to_your_csv_file.csv";
        String jdbcURL = "jdbc:sqlserver://your_server:1433;databaseName=your_database";
        String username = "your_username";
        String password = "your_password";

        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             BufferedReader reader = new BufferedReader(new FileReader(csvFilePath))) {

            String line;
            String sql = "INSERT INTO QuizQuestions (QuestionNumber, Question, OptionA, OptionB, OptionC, OptionD, CorrectAnswer) " +
                    "VALUES (?, ?, ?, ?, ?, ?, ?)";
            PreparedStatement statement = connection.prepareStatement(sql);

            while ((line = reader.readLine()) != null) {
                String[] data = line.split(",");
                statement.setInt(1, Integer.parseInt(data[0].trim()));
                statement.setString(2, data[1].trim());
                statement.setString(3, data[2].trim());
                statement.setString(4, data[3].trim());
                statement.setString(5, data[4].trim());
                statement.setString(6, data[5].trim());
                statement.setString(7, data[6].trim());
                statement.addBatch();
            }

            int[] result = statement.executeBatch();
            System.out.println("Rows affected: " + result.length);
        } catch (Exception e) {
            e.printStackTrace();
        }
    }
}

