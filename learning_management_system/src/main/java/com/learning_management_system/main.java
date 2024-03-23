import java.util.Scanner;

public class Main {
    public static boolean exitRequested = false;

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);

        while (!exitRequested) {
            System.out.println("Type 1 if you are a teacher");
            System.out.println("Type 2 if you are a student");
            System.out.println("Type 3 if you want to exit");
            System.out.println("Type 4 if you want any help");

            int choice = scanner.nextInt();

            switch (choice) {
                case 1:
                    Teacher teacher = new Teacher();
                    teacher.displayInfo();
                    break;
                case 2:
                    Student student = new Student();
                    student.displayInfo();
                    break;
                case 3:
                    Exit.exitProgram();
                    break;
                case 4:
                    Help help = new Help();
                    help.displayInfo();
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }
        }
    }
}



