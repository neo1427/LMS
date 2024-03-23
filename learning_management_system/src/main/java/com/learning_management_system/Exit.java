import java.util.*;
class Exit {
    public static void exitProgram() {
        System.out.println("Visit Again. Goodbye!");
        System.exit(0);
    }

    public static boolean askToContinue(Scanner scanner) {
        System.out.println("Do you want to continue? (yes/no)");
        String choice = scanner.next().toLowerCase();
        return choice.equals("yes");
    }
}