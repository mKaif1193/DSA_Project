import java.util.*;

public class LinkedList {
    Scanner sc = new Scanner(System.in);
    static int choice1;

    LinkedList() {
        do {
            LinkedListMenu();
            choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    new SingleLinkedList();
                    break;
                case 2:
                    new DoubleLinkedList();
                    break;
            }
        } while (choice1 != 3);
    }

    static void LinkedListMenu() {
        System.out.println("\n<========== Linked List Menu ==========>");
        System.out.println("1. Single Linked List \n2. Double Linked List \n3. Exit");
        System.out.print("Choose the Operation (1 to 3) : ");
    }
}

class SingleLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int info;
        Node next;
    }

    static Node start = null;

    static int choice2; // choice2 is for Single Linked List Menu
    static int choice3; // choice3 is for Insertion
    static int choice4; // choice4 is for Deletion
    static int item; // item is the Number/Value which User Want to Insert

    SingleLinkedList() {
        do {
            System.out.println("\n<===== Single Linked List Menu =====>");
            System.out.println("1. Traverse \n2. Insertion \n3. Deletion \n4. Exit");
            System.out.print("Choose the Operation (1 to 4) : ");
            choice2 = sc.nextInt();
            switch (choice2) {
                case 1:
                    Traverse_SLL();
                    break;
                case 2:
                    System.out.print("\nEnter the Item You Want to Insert : ");
                    item = sc.nextInt();
                    System.out.println(
                            "\n1. Insertion At First \n2. Insertion At Last \n3. Insertion Before Searched Node \n4. Insertion After Searched Node \n5. Insertion Before All Searched Nodes \n6. Insertion After All Searched Nodes \n7. Insertion In Exact Middle (Before Given Node) \n8. Insertion In Exact Middle (After Given Node) \n9. Insertion In Ascending Sorted List \n10. Insertion In Descending Sorted List");
                    System.out.print("Choose the Operation (1 to 10) : ");
                    choice3 = sc.nextInt();
                    switch (choice3) {
                        case 1:
                            Insertion_AtFirst_SLL();
                            break;
                        case 2:
                            Insertion_AtLast_SLL();
                            break;
                        case 3:
                            Insertion_Search_BeforeGivenNode_SLL();
                            break;
                        case 4:
                            Insertion_Search_AfterGivenNode_SLL();
                            break;
                        case 5:
                            Insertion_Search_BeforeAllNodes_SLL();
                            break;
                        case 6:
                            Insertion_Search_AfterAllNodes_SLL();
                            break;
                        case 7:
                            Insertion_InMiddle_ExactBGN_SLL();
                            break;
                        case 8:
                            Insertion_InMiddle_ExactAGN_SLL();
                            break;
                        case 9:
                            Insertion_InSortedList_Ascending_SLL();
                            break;
                        case 10:
                            Insertion_InSortedList_Descending_SLL();
                            break;
                    }
                    break;
                case 3:
                    System.out.println(
                            "\n1. Deletion At First \n2. Deletion At Last \n3. Deletion of Exact Middle Node \n4. Deletion of Searched Node \n5. Deletion of All Searched Nodes");
                    System.out.print("Choose the Operation (1 to 5) : ");
                    choice4 = sc.nextInt();
                    switch (choice4) {
                        case 1:
                            Deletion_AtFirst_SLL();
                            break;
                        case 2:
                            Deletion_AtLast_SLL();
                            break;
                        case 3:
                            Deletion_InMiddleExact_SLL();
                            break;
                        case 4:
                            Deletion_SearchNode_SLL();
                            break;
                        case 5:
                            Deletion_AllSearchedNodes_SLL();
                            break;
                    }
                    break;
            }
        } while (choice2 != 4);
    }

    static void Traverse_SLL() {
        if (start == null) {
            System.out.println("\nSingle Linked List is Empty!");
            return;
        }

        Node ptr = start;
        while (ptr != null) {
            System.out.println(ptr.info);
            ptr = ptr.next;
        }
    }

    static void Insertion_AtFirst_SLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.next = start;
        start = ptr;
    }

    static void Insertion_AtLast_SLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.next = null;

        if (start == null) {
            start = ptr;
            return;
        }

        Node ptr1 = start;
        while (ptr1.next != null) {
            ptr1 = ptr1.next;
        }
        ptr1.next = ptr;
    }

    static void Insertion_Search_BeforeGivenNode_SLL() {
        System.out.print("\nEnter the Item Before You Want to Insert : ");
        int sItem = sc.nextInt();

        Node ptr = start;
        while ((ptr != null) && (ptr.info != sItem)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("\nItem Not Found!");
            return;
        }

        Node ptr1 = new Node();
        ptr1.info = item;
        ptr1.next = ptr;

        if (ptr == start) {
            start = ptr1;
            return;
        }

        Node ptr2 = start;
        while (ptr2.next != ptr) {
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr1;
    }

    static void Insertion_Search_AfterGivenNode_SLL() {
        System.out.print("\nEnter the Item After You Want to Insert : ");
        int sItem = sc.nextInt();

        Node ptr = start;
        while ((ptr != null) && (ptr.info != sItem)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("\nItem Not Found!");
            return;
        }

        Node ptr1 = new Node();
        ptr1.info = item;
        ptr1.next = ptr.next;
        ptr.next = ptr1;
    }

    static void Insertion_Search_BeforeAllNodes_SLL() {
        System.out.print("\nEnter the Item Before You Want to Insert : ");
        int sItem = sc.nextInt();

        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            if (ptr.info == sItem) {
                count++;

                Node ptr1 = new Node();
                ptr1.info = item;
                ptr1.next = ptr;

                if (ptr == start) {
                    start = ptr1;
                    ptr = ptr.next;
                } else {
                    Node ptr2 = start;
                    while (ptr2.next != ptr) {
                        ptr2 = ptr2.next;
                    }
                    ptr2.next = ptr1;
                }
            }
            ptr = ptr.next;
        }

        if (count == 0) {
            System.out.println("Item Not Found!");
        }
    }

    static void Insertion_Search_AfterAllNodes_SLL() {
        System.out.print("\nEnter the Item After You Want to Insert : ");
        int sItem = sc.nextInt();

        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            if (ptr.info == sItem) {
                count++;

                Node ptr1 = new Node();
                ptr1.info = item;
                ptr1.next = ptr.next;

                ptr.next = ptr1;
            }
            ptr = ptr.next;
        }

        if (count == 0) {
            System.out.println("Item Not Found!");
        }
    }

    static void Insertion_InMiddle_ExactBGN_SLL() {
        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        int mid = (count / 2) + 1;

        ptr = new Node();
        ptr.info = item;

        if ((count == 0) || (count == 1)) {
            ptr.next = start;
            start = ptr;
            return;
        }

        Node ptr1 = start;
        for (int i = 1; i <= mid - 2; i++) {
            ptr1 = ptr1.next;
        }
        ptr.next = ptr1.next;
        ptr1.next = ptr;
    }

    static void Insertion_InMiddle_ExactAGN_SLL() {
        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        int mid = (count / 2) + 1;

        ptr = new Node();
        ptr.info = item;

        if (count == 0) {
            ptr.next = null;
            start = ptr;
            return;
        }

        Node ptr1 = start;
        for (int i = 1; i <= mid - 1; i++) {
            ptr1 = ptr1.next;
        }
        ptr.next = ptr1.next;
        ptr1.next = ptr;
    }

    static void Insertion_InSortedList_Ascending_SLL() {
        Node ptr0 = start;
        while (ptr0.next != null) {
            if (ptr0.info > (ptr0.next).info) {
                System.out.println("\nSingle Linked List is Not Sorted in Ascending Order!");
                return;
            }
            ptr0 = ptr0.next;
        }

        Node ptr = start;
        while ((ptr != null) && (ptr.info < item)) {
            ptr = ptr.next;
        }

        Node ptr1 = new Node();
        ptr1.info = item;

        if (ptr == null) {
            ptr1.next = null;

            if (start == null) {
                start = ptr1;
                return;
            }

            Node ptr2 = start;
            while (ptr2.next != null) {
                ptr2 = ptr2.next;
            }

            ptr2.next = ptr1;
            return;
        }

        if (ptr == start) {
            ptr1.next = start;
            start = ptr1;
            return;
        }

        Node ptr2 = start;
        while (ptr2.next != ptr) {
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr1;
        ptr1.next = ptr;
    }

    static void Insertion_InSortedList_Descending_SLL() {
        Node ptr0 = start;
        while (ptr0.next != null) {
            if (ptr0.info < (ptr0.next).info) {
                System.out.println("\nSingle Linked List is Not Sorted in Descending Order!");
                return;
            }
            ptr0 = ptr0.next;
        }

        Node ptr = start;
        while ((ptr != null) && (ptr.info > item)) {
            ptr = ptr.next;
        }

        Node ptr1 = new Node();
        ptr1.info = item;

        if (ptr == null) {
            ptr1.next = null;

            if (start == null) {
                start = ptr1;
                return;
            }

            Node ptr2 = start;
            while (ptr2.next != null) {
                ptr2 = ptr2.next;
            }

            ptr2.next = ptr1;
            return;
        }

        if (ptr == start) {
            ptr1.next = start;
            start = ptr1;
            return;
        }

        Node ptr2 = start;
        while (ptr2.next != ptr) {
            ptr2 = ptr2.next;
        }
        ptr2.next = ptr1;
        ptr1.next = ptr;
    }

    static void Deletion_AtFirst_SLL() {
        if (start == null) {
            System.out.println("\nSingle Linked List is Empty!");
            return;
        }
        start = start.next;
    }

    static void Deletion_AtLast_SLL() {
        if (start == null) {
            System.out.println("\nSingle Linked List is Empty!");
            return;
        }

        if (start.next == null) {
            start = null;
            return;
        }

        Node ptr = start;
        while (ptr.next.next != null) {
            ptr = ptr.next;
        }
        ptr.next = null;
    }

    static void Deletion_InMiddleExact_SLL() {
        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        int mid = (count / 2) + 1;

        if (count == 0) {
            System.out.println("\nSingle Linked List is Empty!");
            return;
        }

        if (count == 1) {
            start = null;
            return;
        }

        ptr = start;
        for (int i = 1; i <= mid - 2; i++) {
            ptr = ptr.next;
        }
        ptr.next = (ptr.next).next;
    }

    static void Deletion_SearchNode_SLL() {
        System.out.print("\nEnter the Item You Want to Delete : ");
        int sItem = sc.nextInt();

        Node ptr = start;
        while ((ptr != null) && (ptr.info != sItem)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("\nItem Not Found!");
            return;
        }

        if (ptr == start) {
            start = ptr.next;
            return;
        }

        Node ptr1 = start;
        while (ptr1.next != ptr) {
            ptr1 = ptr1.next;
        }
        ptr1.next = ptr.next;
    }

    static void Deletion_AllSearchedNodes_SLL() {
        System.out.print("\nEnter the Item You Want to Delete : ");
        int sItem = sc.nextInt();

        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            if (ptr.info == sItem) {
                count++;

                if (start == ptr) {
                    start = start.next;
                    ptr = start;
                } else {
                    Node ptr1 = start;
                    while (ptr1.next != ptr) {
                        ptr1 = ptr1.next;
                    }

                    ptr = ptr.next;
                    ptr1.next = ptr;
                }
            } else {
                ptr = ptr.next;
            }
        }

        if (count == 0) {
            System.out.println("Item Not Found!");
        }
    }
}

class DoubleLinkedList {
    static Scanner sc = new Scanner(System.in);

    static class Node {
        int info;
        Node next;
        Node prev;
    }

    static Node start = null;

    static int choice2; // choice2 is for Double Linked List Menu
    static int choice3; // choice3 is for Insertion
    static int choice4; // choice4 is for Deletion
    static int item; // item is the Number/Value which User Want to Insert

    DoubleLinkedList() {
        do {
            System.out.println("\n<===== Double Linked List Menu =====>");
            System.out.println("1. Traverse \n2. Insertion \n3. Deletion \n4. Exit");
            System.out.print("Choose the Operation (1 to 4) : ");
            choice2 = sc.nextInt();
            switch (choice2) {
                case 1:
                    Traverse_DLL();
                    break;
                case 2:
                    System.out.print("\nEnter the Item You Want to Insert : ");
                    item = sc.nextInt();
                    System.out.println(
                            "\n1. Insertion At First \n2. Insertion At Last \n3. Insertion Before Searched Node \n4. Insertion After Searched Node \n5. Insertion Before All Searched Nodes \n6. Insertion After All Searched Nodes \n7. Insertion In Exact Middle (Before Given Node) \n8. Insertion In Exact Middle (After Given Node) \n9. Insertion In Ascending Sorted List \n10. Insertion In Descending Sorted List");
                    System.out.print("Choose the Operation (1 to 10) : ");
                    choice3 = sc.nextInt();
                    switch (choice3) {
                        case 1:
                            Insertion_AtFirst_DLL();
                            break;
                        case 2:
                            Insertion_AtLast_DLL();
                            break;
                        case 3:
                            Insertion_Search_BeforeGivenNode_DLL();
                            break;
                        case 4:
                            Insertion_Search_AfterGivenNode_DLL();
                            break;
                        case 5:
                            Insertion_Search_BeforeAllNodes_DLL();
                            break;
                        case 6:
                            Insertion_Search_AfterAllNodes_DLL();
                            break;
                        case 7:
                            Insertion_InMiddle_ExactBMN_DLL();
                            break;
                        case 8:
                            Insertion_InMiddle_ExactAMN_DLL();
                            break;
                        case 9:
                            Insertion_InSortedList_Ascending_DLL();
                            break;
                        case 10:
                            Insertion_InSortedList_Descending_DLL();
                            break;
                    }
                    break;
                case 3:
                    System.out.println(
                            "\n1.Deletion At First \n2.Deletion At Last \n3.Deletion of Exact Middle Node \n4.Deletion of Searched Node \n5.Deletion of All Searched Nodes");
                    System.out.print("Choose the Operation (1 to 5) : ");
                    choice4 = sc.nextInt();

                    switch (choice4) {
                        case 1:
                            Deletion_AtFirst_DLL();
                            break;
                        case 2:
                            Deletion_AtLast_DLL();
                            break;
                        case 3:
                            Deletion_InMiddleExact_DLL();
                            break;
                        case 4:
                            Deletion_SearchNode_DLL();
                            break;
                        case 5:
                            Deletion_AllSearchedNodes_DLL();
                            break;
                    }
                    break;
            }
        } while (choice2 != 4);
    }

    static void Traverse_DLL() {
        if (start == null) {
            System.out.println("\nDouble Linked List is Empty!");
            return;
        }

        Node ptr = start;
        while (ptr != null) {
            System.out.println(ptr.info);
            ptr = ptr.next;
        }
    }

    static void Insertion_AtFirst_DLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.next = start;
        ptr.prev = null;

        if (start != null) {
            start.prev = ptr;
        }
        start = ptr;
    }

    static void Insertion_AtLast_DLL() {
        Node ptr = new Node();
        ptr.info = item;
        ptr.next = null;

        if (start == null) {
            ptr.prev = null;
            start = ptr;
            return;
        }

        Node ptr1 = start;
        while (ptr1.next != null) {
            ptr1 = ptr1.next;
        }
        ptr1.next = ptr;
        ptr.prev = ptr1;
    }

    static void Insertion_Search_BeforeGivenNode_DLL() {
        System.out.print("\nEnter the Item Before You Want to Insert : ");
        int sItem = sc.nextInt();

        Node ptr = start;
        while ((ptr != null) && (ptr.info != sItem)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("\nItem Not Found!");
            return;
        }

        Node ptr1 = new Node();
        ptr1.info = item;
        ptr1.next = ptr;
        ptr1.prev = ptr.prev;
        ptr.prev = ptr1;

        if (ptr1.prev == null) {
            start = ptr1;
        } else {
            (ptr1.prev).next = ptr1;
        }
    }

    static void Insertion_Search_AfterGivenNode_DLL() {
        System.out.print("\nEnter the Item After You Want to Insert : ");
        int sItem = sc.nextInt();

        Node ptr = start;
        while ((ptr != null) && (ptr.info != sItem)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("\nItem Not Found!");
            return;
        }

        Node ptr1 = new Node();
        ptr1.info = item;
        ptr1.next = ptr.next;

        if (ptr.next != null) {
            (ptr.next).prev = ptr1;
        }
        ptr1.prev = ptr;
        ptr.next = ptr1;
    }

    static void Insertion_Search_BeforeAllNodes_DLL() {
        System.out.print("\nEnter the Item Before You Want to Insert : ");
        int sItem = sc.nextInt();

        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            if (ptr.info == sItem) {
                count++;

                Node ptr1 = new Node();
                ptr1.info = item;
                ptr1.next = ptr;

                if (ptr == start) {
                    ptr1.prev = null;
                    start = ptr1;
                    ptr = ptr.next;
                } else {
                    ptr1.prev = ptr.prev;
                    (ptr.prev).next = ptr1;
                }
                ptr.prev = ptr1;
            }
            ptr = ptr.next;
        }

        if (count == 0) {
            System.out.println("Item Not Found!");
        }
    }

    static void Insertion_Search_AfterAllNodes_DLL() {
        System.out.print("\nEnter the Item After You Want to Insert : ");
        int sItem = sc.nextInt();

        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            if (ptr.info == sItem) {
                count++;

                Node ptr1 = new Node();
                ptr1.info = item;
                ptr1.prev = ptr;
                ptr1.next = ptr.next;

                if (ptr.next != null) {
                    (ptr.next).prev = ptr1;
                }
                ptr.next = ptr1;
            }
            ptr = ptr.next;
        }

        if (count == 0) {
            System.out.println("Item Not Found!");
        }
    }

    static void Insertion_InMiddle_ExactBMN_DLL() {
        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        int mid = (count / 2) + 1;

        ptr = new Node();
        ptr.info = item;

        if (count == 0) {
            ptr.next = null;
            ptr.prev = null;
            start = ptr;
            return;
        }

        if (count == 1) {
            ptr.next = start;
            start.prev = ptr;
            ptr.prev = null;
            start = ptr;
            return;
        }

        Node ptr1 = start;
        for (int i = 1; i <= mid - 1; i++) {
            ptr1 = ptr1.next;
        }
        ptr.next = ptr1;
        ptr.prev = ptr1.prev;
        (ptr.prev).next = ptr;
        ptr1.prev = ptr;
    }

    static void Insertion_InMiddle_ExactAMN_DLL() {
        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        int mid = (count / 2) + 1;

        ptr = new Node();
        ptr.info = item;

        if (count == 0) {
            ptr.next = null;
            ptr.prev = null;
            start = ptr;
            return;
        }

        Node ptr1 = start;
        for (int i = 1; i <= mid - 1; i++) {
            ptr1 = ptr1.next;
        }

        ptr.next = ptr1.next;

        if (ptr.next != null) {
            (ptr.next).prev = ptr;
        }
        ptr1.next = ptr;
        ptr.prev = ptr1;
    }

    static void Insertion_InSortedList_Ascending_DLL() {
        Node ptr0 = start;
        while (ptr0.next != null) {
            if (ptr0.info > (ptr0.next).info) {
                System.out.println("\nDouble Linked List is Not Sorted in Ascending Order!");
                return;
            }
            ptr0 = ptr0.next;
        }

        Node ptr = start;
        while ((ptr != null) && (ptr.info < item)) {
            ptr = ptr.next;
        }

        Node ptr1 = new Node();
        ptr1.info = item;

        if (ptr == null) {
            ptr1.next = null;

            if (start == null) {
                ptr1.prev = null;
                start = ptr1;
                return;
            }

            Node ptr2 = start;
            while (ptr2.next != null) {
                ptr2 = ptr2.next;
            }
            ptr2.next = ptr1;
            ptr1.prev = ptr2;
            return;
        }

        if (ptr == start) {
            ptr1.next = start;
            ptr1.prev = null;
            start.prev = ptr1;
            start = ptr1;
            return;
        }
        (ptr.prev).next = ptr1;
        ptr1.prev = ptr.prev;
        ptr1.next = ptr;
        ptr.prev = ptr1;
    }

    static void Insertion_InSortedList_Descending_DLL() {
        Node ptr0 = start;
        while (ptr0.next != null) {
            if (ptr0.info < (ptr0.next).info) {
                System.out.println("\nDouble Linked List is Not Sorted in Descending Order!");
                return;
            }
            ptr0 = ptr0.next;
        }

        Node ptr = start;
        while ((ptr != null) && (ptr.info > item)) {
            ptr = ptr.next;
        }

        Node ptr1 = new Node();
        ptr1.info = item;

        if (ptr == null) {
            ptr1.next = null;

            if (start == null) {
                ptr1.prev = null;
                start = ptr1;
                return;
            }

            Node ptr2 = start;
            while (ptr2.next != null) {
                ptr2 = ptr2.next;
            }
            ptr2.next = ptr1;
            ptr1.prev = ptr2;
            return;
        }

        if (ptr == start) {
            ptr1.next = start;
            ptr1.prev = null;
            start.prev = ptr1;
            start = ptr1;
            return;
        }
        (ptr.prev).next = ptr1;
        ptr1.prev = ptr.prev;
        ptr1.next = ptr;
        ptr.prev = ptr1;
    }

    static void Deletion_AtFirst_DLL() {
        if (start == null) {
            System.out.println("\nDouble Linked List is Empty!");
            return;
        }

        start = start.next;
        if (start != null) {
            start.prev = null;
        }
    }

    static void Deletion_AtLast_DLL() {
        if (start == null) {
            System.out.println("\nDouble Linked List is Empty!");
            return;
        }

        if (start.next == null) {
            start = null;
            return;
        }

        Node ptr = start;
        while (ptr.next.next != null) {
            ptr = ptr.next;
        }
        ptr.next = null;
    }

    static void Deletion_SearchNode_DLL() {
        System.out.print("\nEnter the Item You Want to Delete : ");
        int sItem = sc.nextInt();

        Node ptr = start;
        while ((ptr != null) && (ptr.info != sItem)) {
            ptr = ptr.next;
        }

        if (ptr == null) {
            System.out.println("\nItem Not Found!");
            return;
        }

        if (ptr == start) {
            start = ptr.next;
            if (start != null) {
                start.prev = null;
            }
            return;
        }
        (ptr.prev).next = ptr.next;

        if (ptr.next != null) {
            (ptr.next).prev = (ptr.prev);
        }
    }

    static void Deletion_InMiddleExact_DLL() {
        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            count++;
            ptr = ptr.next;
        }
        int mid = (count / 2) + 1;

        if (count == 0) {
            System.out.println("\nDouble Linked List is Empty!");
            return;
        }

        if (count == 1) {
            start = null;
            return;
        }

        ptr = start;
        for (int i = 1; i <= mid - 2; i++) {
            ptr = ptr.next;
        }

        Node ptr1 = ptr.next;
        ptr.next = ptr1.next;

        if (ptr1.next != null) {
            (ptr1.next).prev = ptr;
        }
    }

    static void Deletion_AllSearchedNodes_DLL() {
        System.out.print("\nEnter the Item You Want to Delete : ");
        int sItem = sc.nextInt();

        int count = 0;

        Node ptr = start;
        while (ptr != null) {
            if (ptr.info == sItem) {
                count++;

                if (start == ptr) {
                    start = start.next;
                    if (start != null) {
                        start.prev = null;
                    }

                    ptr = start;
                } else {
                    Node ptr1 = start;
                    while (ptr1.next != ptr) {
                        ptr1 = ptr1.next;
                    }

                    ptr = ptr.next;
                    if (ptr != null) {
                        ptr.prev = ptr1;
                    }
                    ptr1.next = ptr;
                }
            } else {
                ptr = ptr.next;
            }
        }

        if (count == 0) {
            System.out.println("Item Not Found!");
        }
    }
}