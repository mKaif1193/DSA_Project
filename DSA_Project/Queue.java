import java.util.*;

public class Queue {
    static Scanner sc = new Scanner(System.in);

    static int choice; // choice is for QueueMenu
    static int choice1; // choice1 is for Queue on Linked List

    Queue() {
        do {
            QueueMenu();
            choice = sc.nextInt();
            switch (choice) {
                case 1:
                    new Queue_Array();
                    break;
                case 2:
                    do {
                        System.out.println("\n<======= Queue on Linked List =======>");
                        System.out.println("1. Single Linked List \n2. Double Linked List \n3. Exit");
                        System.out.print("Choose the Operation (1 to 3) : ");
                        choice1 = sc.nextInt();

                        switch (choice1) {
                            case 1:
                                new Queue_SingleLinkedList();
                                break;
                            case 2:
                                new Queue_DoubleLinkedList();
                                break;
                        }
                    } while (choice1 != 3);
                    break;
            }
        } while (choice != 3);
    }

    static void QueueMenu() {
        System.out.println("\n<======= Queue Main Menu =======>");
        System.out.println("1. Queue on Array \n2. Queue on Linked List \n3. Exit");
        System.out.print("Choose the Operation (1 to 3) : ");
    }
}

class Queue_Array {
    static Scanner sc = new Scanner(System.in);

    static int choice1; // choice1 is for Queue Menu on Array
    static int choice2; // choice2 is for Simple and Circular Queue on Array

    static int LB = 0; // LB is the Lower Bound of the Queue on Array
    static int F = LB - 1; // F is the Front Index of the Queue on Array
    static int R = LB - 1;// R is the Rear Index of the Queue on Array
    static int size; // size is the Size of the Queue on Array
    static int[] Q; // Q is the Simple Queue on Array
    static int[] CQ;// CQ is the Circular Queue on Array
    static int item; // item is the Number/Value which User Want to Insert/Delete

    Queue_Array() {
        do {
            System.out.println("\n<======= Queue on Array =======>");
            System.out.println("1. Simple Queue \n2. Circular Queue \n3. Exit");
            System.out.print("Choose the Operation (1 to 3) : ");
            choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    System.out.print("\nEnter the Size of the Simple Queue : ");
                    size = sc.nextInt();
                    Q = new int[size];
                    do {
                        System.out.println("\n<===== Simple Queue on Array =====>");
                        System.out.println("1. Insertion \n2. Deletion \n3. Display \n4. Exit");
                        System.out.print("Choose the Operation (1 to 4) : ");
                        choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.print("\nEnter the Item You Want to Insert : ");
                                item = sc.nextInt();
                                SimpleQueueInsert();
                                break;
                            case 2:
                                SimpleQueueDelete();
                                break;
                            case 3:
                                SimpleQueueDisplay();
                                break;
                        }
                    } while (choice2 != 4);
                    break;
                case 2:
                    System.out.print("\nEnter the Size of the Circular Queue : ");
                    size = sc.nextInt();
                    CQ = new int[size];
                    do {
                        System.out.println("\n<===== Circular Queue on Array =====>");
                        System.out.println("1. Insertion \n2. Deletion \n3. Display \n4. Exit");
                        System.out.print("Choose the Operation (1 to 4) : ");
                        choice2 = sc.nextInt();
                        switch (choice2) {
                            case 1:
                                System.out.print("\nEnter the Item You Want to Insert : ");
                                item = sc.nextInt();
                                CircularQueueInsert();
                                break;
                            case 2:
                                CircularQueueDelete();
                                break;
                            case 3:
                                CircularQueueDisplay();
                                break;
                        }
                    } while (choice2 != 4);
                    break;
            }
        } while (choice1 != 3);
    }

    static void SimpleQueueDisplay() {
        if (F == (LB - 1)) {
            System.out.println("\nSimple Queue is Empty!");
            return;
        }
        System.out.println("\nThe Elements in the Simple Queue are :");
        for (int i = F; i <= R; i++) {
            System.out.println(Q[i]);
        }
    }

    static void SimpleQueueInsert() {
        if (R == (size + LB - 1)) {
            System.out.println("\nSimple Queue is Full!");
            return;
        }

        if (R == (LB - 1)) {
            R = LB;
            F = LB;
        } else {
            R++;
        }
        Q[R] = item;
    }

    static void SimpleQueueDelete() {
        if (F == (LB - 1)) {
            System.out.println("\nSimple Queue is Empty!");
            return;
        }
        item = Q[F];

        if (F == R) {
            F = LB - 1;
            R = LB - 1;
        } else {
            F++;
        }
    }

    static void CircularQueueDisplay() {
        if (F == LB - 1) {
            System.out.println("\nCircular Queue is Empty!");
            return;
        }
        System.out.println("\nThe Elements in the Circular Queue are :");

        int i = F;
        while (i != R) {
            System.out.println(CQ[i]);
            i = (i + 1) % size;
        }
        System.out.println(CQ[i]);
    }

    static void CircularQueueInsert() {
        if ((R == (size + LB - 1) && F == LB) || R == F - 1) {
            System.out.println("\nCircular Queue is Full!");
            return;
        }

        if (R == LB - 1) {
            R = LB;
            F = LB;
        } else {
            if (R == size + LB - 1) {
                R = LB;
            } else {
                R++;
            }
        }
        CQ[R] = item;
    }

    static void CircularQueueDelete() {
        if (F == LB - 1) {
            System.out.println("\nCircular Queue is Empty!");
            return;
        }
        item = CQ[F];

        if (F == R) {
            F = LB - 1;
            R = LB - 1;
        } else {
            if (F == size + LB - 1) {
                F = LB;
            } else {
                F++;
            }
        }
    }
}

class Queue_SingleLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int info;
        Node next;
    }

    static Node F = null; // F is the Front of the Queue on Single Linked List
    static Node R = null; // R is the Rear of the Queue on Single Linked List

    static int choice2; // choice2 is for Queue Menu on Single Linked List
    static int item; // item is the Number/Value which User Want to Enqueue/Dequeue

    Queue_SingleLinkedList() {
        do {
            System.out.println("\n<===== Queue on Single Linked List =====>");
            System.out.println("1. Enqueue \n2. Dequeue \n3. Display \n4. Exit");
            System.out.print("Choose the Operation (1 to 4) : ");
            choice2 = sc.nextInt();
            switch (choice2) {
                case 1:
                    System.out.print("\nEnter the Item You Want to Enqueue (Insert) : ");
                    item = sc.nextInt();
                    Enqueue_SLL();
                    break;
                case 2:
                    Dequeue_SLL();
                    break;
                case 3:
                    Display_SLL();
                    break;
            }
        } while (choice2 != 4);
    }

    static void Enqueue_SLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.next = null;

        if (R == null) {
            R = ptr;
            F = ptr;
        } else {
            R.next = ptr;
            R = ptr;
        }
    }

    static void Dequeue_SLL() {
        if (F == null) {
            System.out.println("\nQueue is Empty!");
            return;
        }
        F = F.next;

        if (F == null) {
            R = null;
        }
    }

    static void Display_SLL() {
        if (F == null) {
            System.out.println("\nQueue is Empty!");
            return;
        }
        System.out.println("\nThe Elements in the Queue are :");

        Node ptr = F;
        while (ptr != null) {
            System.out.println(ptr.info);
            ptr = ptr.next;
        }
    }
}

class Queue_DoubleLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int info;
        Node next;
        Node prev;
    }

    static Node F = null; // F is the Front of the Queue on Double Linked List
    static Node R = null; // R is the Rear of the Queue on Double Linked List

    static int choice2; // choice2 is for Queue Menu on Double Linked List
    static int item; // item is the Number/Value which User Want to Enqueue/Dequeue

    Queue_DoubleLinkedList() {
        do {
            System.out.println("\n<===== Queue on Double Linked List =====>");
            System.out.println("1. Enqueue \n2. Dequeue \n3. Display \n4. Exit");
            System.out.print("Choose the Operation (1 to 4) : ");
            choice2 = sc.nextInt();
            switch (choice2) {
                case 1:
                    System.out.print("\nEnter the Item You Want to Enqueue (Insert) : ");
                    item = sc.nextInt();
                    Enqueue_DLL();
                    break;
                case 2:
                    Dequeue_DLL();
                    break;
                case 3:
                    Display_DLL();
                    break;
            }
        } while (choice2 != 4);
    }

    static void Enqueue_DLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.next = null;
        ptr.prev = R;

        if (R == null) {
            R = ptr;
            F = ptr;
        } else {
            R.next = ptr;
            R = ptr;
        }
    }

    static void Dequeue_DLL() {
        if (F == null) {
            System.out.println("\nQueue is Empty!");
            return;
        }
        F = F.next;

        if (F == null) {
            R = null;
        } else {
            F.prev = null;
        }
    }

    static void Display_DLL() {
        if (F == null) {
            System.out.println("\nQueue is Empty!");
            return;
        }
        System.out.println("\nThe Elements in the Queue are :");

        Node ptr = F;
        while (ptr != null) {
            System.out.println(ptr.info);
            ptr = ptr.next;
        }
    }
}