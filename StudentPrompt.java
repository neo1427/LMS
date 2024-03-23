import java.util.*;
class Student {
    private int studentId;

    public Student(int studentId) {
        this.studentId = studentId;
    }

    public void attemptQuiz(Scanner scanner) {
        // Fetch quiz details from Quiz class or Teacher class
        Quiz quiz = new Quiz(1, "10:00 AM", 10, "10:30 AM", QuestionBank.questions, QuestionBank.options);
        quiz.displayQuestions(scanner);
        quiz.viewResults();
    }

    public void viewResults(Scanner scanner) {
        System.out.println("Viewing results as student " + studentId + ".");
        // Logic to view results
    }

    public void showPrompts(Scanner scanner) {
        System.out.println("\nStudent Main Prompt:");
        System.out.println("What action do you want to perform:");
        System.out.println("1. Attend a Quiz");
        System.out.println("2. See Results");
        System.out.println("3. Exit");

        while (true) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    attemptQuiz(scanner);
                    break;
                case 2:
                    viewResults(scanner);
                    break;
                case 3:
                    if (Exit.askToContinue(scanner)) {
                        return;
                    } else {
                        Exit.exitProgram();
                    }
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
            if (!continueOrStop(scanner))
                Exit.exitProgram();
        }
    }
    private boolean continueOrStop(Scanner scanner) {
        System.out.print("Do you want to continue? (yes/no): ");
        String choice = scanner.next().toLowerCase();
        return choice.equals("yes");
    }
}