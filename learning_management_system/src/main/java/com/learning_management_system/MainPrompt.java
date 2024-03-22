package com.learning_management_system;


import java.util.*;

class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        JDBCServer jdbcServer = new JDBCServer();

        while (true) {
            System.out.println("UI Side Display:");
            System.out.println("Are you a student or teacher:");
            System.out.println("1. Student");
            System.out.println("2. Teacher");
            System.out.println("3. Exit");
            System.out.print("User Input: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    StudentPrompt studentPrompt = new StudentPrompt(jdbcServer);
                    studentPrompt.showStudentPrompts();
                    break;
                case 2:
                    TeacherPrompt teacherPrompt = new TeacherPrompt(jdbcServer);
                    teacherPrompt.showTeacherPrompts();
                    break;
                case 3:
                    System.out.println("Exiting...");
                    jdbcServer.closeConnection();
                    System.exit(0);
                default:
                    System.out.println("Invalid option. Please try again.");
            }
        }
    }
}