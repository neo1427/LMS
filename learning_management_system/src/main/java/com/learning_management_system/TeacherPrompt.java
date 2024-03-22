package com.learning_management_system;

import java.util.*;
class TeacherPrompt {
    private JDBCServer jdbcServer;

    public TeacherPrompt(JDBCServer jdbcServer) {
        this.jdbcServer = jdbcServer;
    }

    public void showTeacherPrompts() {
        Scanner scanner = new Scanner(System.in);
        while (true) {
            System.out.println("\nTeacher Prompts:");
            System.out.println("What action do you want to perform?");
            System.out.println("1. Create a Quiz");
            System.out.println("2. See Results");
            System.out.println("3. Exit");
            System.out.print("User Input: ");
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    QuizManager quizManager = new QuizManager(jdbcServer);
                    quizManager.createQuiz();
                    break;
                case 2:
                    QuizResultViewer resultViewer = new QuizResultViewer(jdbcServer);
                    resultViewer.viewTeacherResults();
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
