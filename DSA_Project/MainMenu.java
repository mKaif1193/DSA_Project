import java.util.*;

public class MainMenu {

    MainMenu() {
        System.out.println("\n<==================== MAIN MENU ====================>");
        System.out.println("1. Array \n2. Linked List \n3. Stack \n4. Queue \n5. Exit");
        System.out.print("Choose the Operation (1 to 5) : ");
    }

    static int choice; // choice is for MainMenu

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        do {
            new MainMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new Array();
                    break;
                case 2:
                    new LinkedList();
                    break;
                case 3:
                    new Stack();
                    break;
                case 4:
                    new Queue();
                    break;
            }
        } while (choice != 5);
        sc.close(); // It is Optional to Close the Scanner
    }
}