import java.util.*;

public class Stack {
    static Scanner sc = new Scanner(System.in);

    static int choice; // choice is for StackMenu
    static int choice1; // choice1 is for Stack on Linked List

    Stack() {
        do {
            StackMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new Stack_Array();
                    break;
                case 2:
                    do {
                        System.out.println("\n<======= Stack on Linked List =======>");
                        System.out.println("1. Single Linked List \n2. Double Linked List \n3. Exit");
                        System.out.print("Choose the Operation (1 to 3) : ");
                        choice1 = sc.nextInt();
                        switch (choice1) {
                            case 1:
                                new Stack_SingleLinkedList();
                                break;
                            case 2:
                                new Stack_DoubleLinkedList();
                                break;
                        }
                    } while (choice1 != 3);
                    break;
            }
        } while (choice != 3);
    }

    static void StackMenu() {
        System.out.println("\n<========== Stack Main Menu ==========>");
        System.out.println("1. Stack Implemented on Array \n2. Stack Implemented on Linked List \n3. Exit");
        System.out.print("Choose the Operation (1 to 3) : ");
    }
}

class Stack_Array {
    static Scanner sc = new Scanner(System.in);

    static int LB = 0; // LB is the Lower Bound of the Stack
    static int Top = LB - 1; // Top is the Top of the Stack
    static int choice1; // choice1 is for Stack Menu on Array
    static int size; // size is the Size of the Stack
    static int[] St; // St is the Stack of Array
    static int item; // item is the Number/Value which User Want to PUSH/POP

    Stack_Array() {
        System.out.print("\nEnter the Size of the Stack : ");
        size = sc.nextInt();
        St = new int[size];
        do {
            System.out.println("\n<===== Stack on Array =====>");
            System.out.println("1. PUSH \n2. POP \n3. Display \n4. Exit");
            System.out.print("Choose the Operation (1 to 4) : ");
            choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    System.out.print("\nEnter the Item You Want to PUSH : ");
                    item = sc.nextInt();
                    Push();
                    break;
                case 2:
                    Pop();
                    break;
                case 3:
                    Display();
                    break;
            }
        } while (choice1 != 4);
    }

    static void Display() {
        if (Top == (LB - 1)) {
            System.out.println("\nStack is Empty!");
            return;
        }
        System.out.println("\nThe Elements in the Stack are :");

        for (int i = Top; i >= LB; i--) {
            System.out.println(St[i]);
        }
    }

    static void Push() {
        if (Top == (size + LB - 1)) {
            System.out.println("\nStack is Full!");
            return;
        }
        Top++;
        St[Top] = item;
    }

    static void Pop() {
        if (Top == (LB - 1)) {
            System.out.println("\nStack is Empty!");
            return;
        }
        Top--;
    }
}

class Stack_SingleLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int info;
        Node next;
    }

    static Node Top = null; // Top is the Top Node of the Stack on Single Linked List

    static int choice2; // choice1 is for Stack Menu on Single Linked List
    static int item; // item is the Number/Value which User Want to PUSH/POP

    Stack_SingleLinkedList() {
        do {
            System.out.println("\n<===== Stack on Single Linked List =====>");
            System.out.println("1. PUSH \n2. POP \n3. Display \n4. Exit");
            System.out.print("Choose the Operation (1 to 4) : ");
            choice2 = sc.nextInt();

            switch (choice2) {
                case 1:
                    System.out.print("\nEnter the Item You Want to PUSH : ");
                    item = sc.nextInt();
                    Push_SLL();
                    break;
                case 2:
                    Pop_SLL();
                    break;
                case 3:
                    Display_SLL();
                    break;
            }
        } while (choice2 != 4);
    }

    static void Push_SLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.next = Top;
        Top = ptr;
    }

    static void Pop_SLL() {
        if (Top == null) {
            System.out.println("\nStack is Empty!");
            return;
        }
        Top = Top.next;
    }

    static void Display_SLL() {
        if (Top == null) {
            System.out.println("\nStack is Empty!");
            return;
        }
        System.out.println("\nThe Elements in the Stack are :");

        Node ptr = Top;
        while (ptr != null) {
            System.out.println(ptr.info);
            ptr = ptr.next;
        }
    }
}

class Stack_DoubleLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int info;
        Node next;
        Node prev;
    }

    static Node Top = null; // Top is the Top Node of the Stack on Double Linked List

    static int choice2; // choice1 is for Stack Menu on Double Linked List
    static int item; // item is the Number/Value which User Want to PUSH/POP

    Stack_DoubleLinkedList() {
        do {
            System.out.println("\n<===== Stack on Double Linked List =====>");
            System.out.println("1. PUSH \n2. POP \n3. Display \n4. Exit");
            System.out.print("Choose the Operation (1 to 4) : ");
            choice2 = sc.nextInt();

            switch (choice2) {
                case 1:
                    System.out.print("\nEnter the Item You Want to PUSH : ");
                    item = sc.nextInt();
                    Push_DLL();
                    break;
                case 2:
                    Pop_DLL();
                    break;
                case 3:
                    Display_DLL();
                    break;
            }
        } while (choice2 != 4);
    }

    static void Push_DLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.prev = null;
        ptr.next = Top;

        if (Top != null) {
            Top.prev = ptr;
        }
        Top = ptr;
    }

    static void Pop_DLL() {
        if (Top == null) {
            System.out.println("\nStack is Empty!");
            return;
        }
        Top = Top.next;

        if (Top != null) {
            Top.prev = null;
        }
    }

    static void Display_DLL() {
        if (Top == null) {
            System.out.println("\nStack is Empty!");
            return;
        }
        System.out.println("\nThe Elements in the Stack are :");

        Node ptr = Top;
        while (ptr != null) {
            System.out.println(ptr.info);
            ptr = ptr.next;
        }
    }
}