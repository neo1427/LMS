package com.learning_management_system;

import java.io.FileOutputStream;
import java.io.IOException;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;
import java.sql.SQLException;
import java.util.Scanner;
import org.apache.poi.ss.usermodel.Cell;
import org.apache.poi.ss.usermodel.Row;
import org.apache.poi.xssf.usermodel.XSSFSheet;
import org.apache.poi.xssf.usermodel.XSSFWorkbook;

public class QuizQuestionBank {
    private static final String csvFilePath = "path_to_your_csv_file.csv";
    private static final String jdbcURL = "jdbc:sqlserver://your_server:1433;databaseName=your_database";
    private static final String username = "your_username";
    private static final String password = "your_password";

    public static void main(String[] args) {
        try (Connection connection = DriverManager.getConnection(jdbcURL, username, password);
             Scanner scanner = new Scanner(System.in)) {

            XSSFWorkbook workbook = new XSSFWorkbook();
            XSSFSheet sheet = workbook.createSheet("QuizQuestions");

            System.out.println("Enter number of questions:");
            int numQuestions = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            for (int i = 0; i < numQuestions; i++) {
                System.out.println("Enter Question " + (i + 1) + ":");
                String question = scanner.nextLine();

                System.out.println("Enter Option A:");
                String optionA = scanner.nextLine();

                System.out.println("Enter Option B:");
                String optionB = scanner.nextLine();

                System.out.println("Enter Option C:");
                String optionC = scanner.nextLine();

                System.out.println("Enter Option D:");
                String optionD = scanner.nextLine();

                System.out.println("Enter Correct Answer (A, B, C, or D):");
                String correctAnswer = scanner.nextLine();

                // Save to Excel
                Row row = sheet.createRow(i);
                row.createCell(0).setCellValue(i + 1);
                row.createCell(1).setCellValue(question);
                row.createCell(2).setCellValue(optionA);
                row.createCell(3).setCellValue(optionB);
                row.createCell(4).setCellValue(optionC);
                row.createCell(5).setCellValue(optionD);
                row.createCell(6).setCellValue(correctAnswer);

                // Save to SQL Server
                String sql = "INSERT INTO QuizQuestions (QuestionNumber, Question, OptionA, OptionB, OptionC, OptionD, CorrectAnswer) " +
                        "VALUES (?, ?, ?, ?, ?, ?, ?)";
                try (PreparedStatement statement = connection.prepareStatement(sql)) {
                    statement.setInt(1, i + 1);
                    statement.setString(2, question);
                    statement.setString(3, optionA);
                    statement.setString(4, optionB);
                    statement.setString(5, optionC);
                    statement.setString(6, optionD);
                    statement.setString(7, correctAnswer);
                    statement.executeUpdate();
                } catch (SQLException e) {
                    e.printStackTrace();
                }
            }

            // Write the Excel file
            try (FileOutputStream outputStream = new FileOutputStream(csvFilePath)) {
                workbook.write(outputStream);
                System.out.println("Excel file saved successfully.");
            } catch (IOException e) {
                e.printStackTrace();
            }

        } catch (SQLException e) {
            e.printStackTrace();
        }
    }
}

