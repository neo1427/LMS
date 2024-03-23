import java.util.*;


public class MainPrompt {
    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        System.out.println("-----WELCOME TO IAMNEO-----");
        System.out.println("What action do you want to perform:");
        //System.out.println("What action do you want to perform:");
        String input = scanner.nextLine();

        System.out.println("Are you a student or teacher:");
        System.out.println("Type 1 if you are a Student");
        System.out.println("Type 2 if you are a Teacher");
        System.out.println("Type 3 to Exit");


        while (true) {
            int option = scanner.nextInt();

            switch (option) {
                case 1:
                    System.out.print("Enter Student ID: ");
                    int studentId = scanner.nextInt();
                    Student student = new Student(studentId);
                    student.showPrompts(scanner);
                    break;
                case 2:
                    System.out.print("Enter Teacher ID: ");
                    int teacherId = scanner.nextInt();
                    Teacher teacher = new Teacher(teacherId);
                    teacher.showPrompts(scanner);
                    break;
                case 3:
                    Exit.exitProgram();
                default:
                    System.out.println("Invalid option. Please select 1, 2, or 3.");
            }
        }
    }
}
