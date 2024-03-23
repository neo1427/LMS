import java.io.File;
import java.io.FileInputStream;
import java.sql.Connection;
import java.sql.DriverManager;
import java.sql.PreparedStatement;

import org.apache.poi.ss.usermodel.*;

public class Main {
    public static void main(String[] args) {
        String excelFilePath = "C:\\Users\\Bharat ravi\\OneDrive\\Desktop\\LMS data\\dataset.xlsx";
        String jdbcURL = "jdbc:mysql://localhost/datas";
        String username = "root";
        String password = "root";

        try {
            Class.forName("com.mysql.cj.jdbc.Driver"); // Load the MySQL JDBC driver

            try (Connection connection = DriverManager.getConnection(jdbcURL, username, password)) {
                File file = new File(excelFilePath);
                FileInputStream inputStream = new FileInputStream(file);

                Workbook workbook = WorkbookFactory.create(inputStream);
                Sheet sheet = workbook.getSheetAt(0);

                String createTableSQL = "CREATE TABLE IF NOT EXISTS questions (QuestionNumber int, Question VARCHAR(255), OptionA VARCHAR(255), OptionB VARCHAR(255), OptionC VARCHAR(255), OptionD VARCHAR(255), CorrectAnswer VARCHAR(255))";
                connection.createStatement().executeUpdate(createTableSQL);

                String insertSQL = "INSERT INTO questions (QuestionNumber, Question, OptionA, OptionB, OptionC, OptionD, CorrectAnswer) VALUES (?, ?, ?, ?, ?, ?, ?)";
                PreparedStatement preparedStatement = connection.prepareStatement(insertSQL);

                for (Row row : sheet) {
                    Cell cell1 = row.getCell(0);
                    Cell cell2 = row.getCell(1);
                    Cell cell3 = row.getCell(2);
                    Cell cell4 = row.getCell(3);
                    Cell cell5 = row.getCell(4);
                    Cell cell6 = row.getCell(5);
                    Cell cell7 = row.getCell(6);

                    if (cell1 != null && cell2 != null && cell3 != null && cell4 != null && cell5 != null && cell6 != null && cell7 != null) {
                        String value1 = "";
                        String value2 = "";
                        String value3 = "";
                        String value4 = "";
                        String value5 = "";
                        String value6 = "";
                        String value7 = "";

                        switch (cell1.getCellType()) {
                            case STRING:
                                value1 = cell1.getStringCellValue();
                                break;
                            case NUMERIC:
                                value1 = String.valueOf(cell1.getNumericCellValue());
                                break;
                            // Handle other cell types if necessary
                        }

                        switch (cell2.getCellType()) {
                            case STRING:
                                value2 = cell2.getStringCellValue();
                                break;
                            case NUMERIC:
                                value2 = String.valueOf(cell2.getNumericCellValue());
                                break;
                            // Handle other cell types if necessary
                        }

                        switch (cell3.getCellType()) {
                            case STRING:
                                value3 = cell3.getStringCellValue();
                                break;
                            case NUMERIC:
                                value3 = String.valueOf(cell3.getNumericCellValue());
                                break;
                            // Handle other cell types if necessary
                        }

                        switch (cell4.getCellType()) {
                            case STRING:
                                value4 = cell4.getStringCellValue();
                                break;
                            case NUMERIC:
                                value4 = String.valueOf(cell4.getNumericCellValue());
                                break;
                            // Handle other cell types if necessary
                        }

                        switch (cell5.getCellType()) {
                            case STRING:
                                value5 = cell5.getStringCellValue();
                                break;
                            case NUMERIC:
                                value5 = String.valueOf(cell5.getNumericCellValue());
                                break;
                            // Handle other cell types if necessary
                        }

                        switch (cell6.getCellType()) {
                            case STRING:
                                value6 = cell6.getStringCellValue();
                                break;
                            case NUMERIC:
                                value6 = String.valueOf(cell6.getNumericCellValue());
                                break;
                            // Handle other cell types if necessary
                        }

                        switch (cell7.getCellType()) {
                            case STRING:
                                value7 = cell7.getStringCellValue();
                                break;
                            case NUMERIC:
                                value7 = String.valueOf(cell7.getNumericCellValue());
                                break;
                            // Handle other cell types if necessary
                        }

                        preparedStatement.setString(1, value1);
                        preparedStatement.setString(2, value2);
                        preparedStatement.setString(3, value3);
                        preparedStatement.setString(4, value4);
                        preparedStatement.setString(5, value5);
                        preparedStatement.setString(6, value6);
                        preparedStatement.setString(7, value7);

                        preparedStatement.addBatch();
                    }
                }

                preparedStatement.executeBatch();

                workbook.close();
                inputStream.close();

                System.out.println("Data imported successfully.");

            } catch (Exception e) {
                e.printStackTrace();
            }
        } catch (ClassNotFoundException e) {
            e.printStackTrace();
        }
    }
}
