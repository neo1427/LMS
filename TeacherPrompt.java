import java.util.Scanner;

class Teacher {
    private int teacherId;

    public Teacher(int teacherId) {
        this.teacherId = teacherId;
    }

    public void createQuiz(Scanner scanner) {
        System.out.println("Creating a new quiz as teacher " + teacherId + ".");
        System.out.print("Enter Start Time (HH:mm): ");
        String startTime = scanner.next();
        System.out.print("Enter Buffer Time (minutes): ");
        int bufferTime = scanner.nextInt();
        System.out.print("Enter End Time (HH:mm): ");
        String endTime = scanner.next();

        // Fetch questions and options from QuestionBank
        String[] questions = QuestionBank.questions;
        String[][] options = QuestionBank.options;

        // Create a new quiz
        Quiz quiz = new Quiz(1, startTime, bufferTime, endTime, questions, options);
        // Save the quiz or perform further operations
        
        System.out.println("Quiz created successfully with the following details:");
        System.out.println("Start Time: " + startTime);
        System.out.println("Buffer Time: " + bufferTime + " minutes");
        System.out.println("End Time: " + endTime);
    }

    public void showPrompts(Scanner scanner) {
        while (true) {
            System.out.println("\nTeacher Main Prompt:");
            System.out.println("What action do you want to perform:");
            System.out.println("1. Create a Quiz");
            System.out.println("2. Grade Quizzes");
            System.out.println("3. Exit");

            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    createQuiz(scanner);
                    break;
                case 2:
                    System.out.println("Grading quizzes...");
                    // Logic to grade quizzes
                    break;
                case 3:
                    Exit.exitProgram();
                    break;
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
    }
}