import java.util.Scanner;

public class Main {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        // Assume user has already selected the appropriate option to reach this point
        questionCreationPrompt(scanner);

        scanner.close();
    }

    public static void questionCreationPrompt(Scanner scanner) {
        System.out.println("Question Creation Prompt:");
        System.out.println("How would you like to insert the questions for the quiz?");
        System.out.println("1. Via Excel");
        System.out.println("2. Via Command Line Interface (CLI)");

        int choice = scanner.nextInt();
        switch (choice) {
            case 1:
                excelPathPrompt(scanner);
                break;
            case 2:
                enterQuestionPrompt(scanner);
                break;
            default:
                System.out.println("Invalid choice. Please select again.");
                questionCreationPrompt(scanner); // Recursive call to handle invalid input
                break;
        }
    }

    public static void excelPathPrompt(Scanner scanner) {
        System.out.println("Excel Path Prompt:");
        System.out.println("Please enter the path for the Excel file containing the questions.");
        System.out.println("The file should have the following columns:");
        System.out.println("1. Question Number.");
        System.out.println("2. Question.");
        System.out.println("3. Options (All options should be separated by the \"%&&%\" string.)");
        System.out.println("4. Correct answer in the form of alphabets.");

        String path = scanner.next();
        // Implement logic to validate the path and file format
    }

    public static void enterQuestionPrompt(Scanner scanner) {
        System.out.println("Enter Question Prompt:");
        System.out.println("Enter the question:");
        String question = scanner.next();

        System.out.println("Enter the number of options:");
        int numOptions = scanner.nextInt();

        String[] options = new String[numOptions];
        System.out.println("Enter the options:");
        for (int i = 0; i < numOptions; i++) {
            options[i] = scanner.next();
        }

        System.out.println("Enter the correct option:");
        String correctOption = scanner.next();
        // Implement logic to process the entered question
    }
}
