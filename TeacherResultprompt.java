package com.example;

import java.util.Scanner;

public class TeacherResultprompt {
    
    public static void showResultsForQuiz(Scanner scanner) {
        System.out.println("Teacher Result Prompt:");
        System.out.println("Enter the quiz number to see the details:");

        int selectedQuizNumber = scanner.nextInt();
        // Implement logic to display student results for the selected quiz
        System.out.println("Showing student results for Quiz Number: " + selectedQuizNumber);
    }
}
