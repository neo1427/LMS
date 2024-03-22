import java.util.Scanner;

public class TeacherPrompt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        int option;

        // Main prompt for teacher
        do {
            // Display menu options
            System.out.println("Teacher Prompts:");
            System.out.println("What action do you want to perform?");
            System.out.println("1. Create a Quiz");
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
                    // Create a quiz
                    createQuiz();
                    break;
                case 2:
                    // See results
                    showResults();
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

    // Method to create a quiz
    private static void createQuiz() {
        System.out.println("Creating a quiz...");
        // Implement quiz creation logic here
    }

    // Method to show results
    private static void showResults() {
        System.out.println("Showing results...");
        // Implement logic to display results
    }
}
