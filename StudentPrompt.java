package com.example;

import java.util.Scanner;

public class StudentPrompt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Main prompt for student
        do {
            // Display menu options
            System.out.println("Student Main Prompt:");
            System.out.println("What action do you want to perform:");
            System.out.println("1. Attend a Quiz");
            System.out.println("2. See Results");
            System.out.println("3. Exit");
            System.out.print("User Input: ");

            // Ensure that user input is an integer
            while (!scanner.hasNextInt()) {
                System.out.println("Invalid input! Please enter a number (1, 2, or 3).");
                scanner.nextLine(); // Consume invalid input
                System.out.print("User Input: ");
            }
            option = scanner.nextInt();
            scanner.nextLine(); // Consume newline

            // Handle user option
            switch (option) {
                case 1:
                    // Attend a quiz
                    studentResultPrompt(scanner);
                    break;
                case 2:
                    // See results
                    System.out.println("Showing student results...");
                    break;
                case 3:
                    // Exit the program
                    System.out.println("Exiting the program...");
                    break;
                default:
                    // Invalid option
                    System.out.println("Invalid option! Please enter 1, 2, or 3.");
            }
        } while (option != 3);

        scanner.close();
    }

    // Student Result Prompt method
    private static void studentResultPrompt(Scanner scanner) {
        System.out.println("Student Result Prompt:");
        System.out.println("Select the quiz you want to attend:");
        // Display list of quizzes and their details here
        System.out.println("1. Quiz 1 (Date: 2024-03-23, Time: 10:00 AM)");
        System.out.println("2. Quiz 2 (Date: 2024-03-24, Time: 10:00 PM)");
        System.out.print("User Input: ");
        int quizNumber = scanner.nextInt();
        scanner.nextLine(); // Consume newline
        System.out.println("Quiz " + quizNumber + " selected.");

        // Check if the student wants to start the quiz
        System.out.println("Do you want to start the quiz? (Y/N):");
        System.out.print("User Input: ");
        String startQuiz = scanner.nextLine();

        if (startQuiz.equalsIgnoreCase("Y")) {
            // Display quiz details and questions
            System.out.println("Starting quiz...");
            // Implement code to display quiz questions
        } else {
            System.out.println("Exiting the program...");
        }
    }
}
