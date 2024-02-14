import java.util.*;

public class Array {
    static Scanner sc = new Scanner(System.in);

    static int LB = 0; // LB is the Lower Bound of an Array
    static int choice1; // choice1 is for ArrayMenu
    static int choice2; // choice2 is for Linear and Binary Search
    static int choice3; // choice3 is for Single and Multi Linear Search
    static int choice4; // choice4 is for Single and Multi Binary Search
    static int choice5; // choice5 is for Ascending and Descending Sorting Order
    static int choice6; // choice6 is for Ascending (Bubble,Selection,Insertion,Shell,Merge,Quick) Sorts
    static int choice7; // choice7 is for Descending (Bubble,Selection,Insertion,Shell,Merge,Quick)
                        // Sorts

    static int N = 0; // N is the Number of Elements in an Array
    static int size = 20; // size is the Size of an Array
    static int[] A = new int[size];

    static int k; // k is the Index Number in which User Want to Insert/Delete
    static int item; // item is the Insertion Number/Value which User Want to Insert

    Array() {
        do {
            ArrayMenu();
            choice1 = sc.nextInt();
            switch (choice1) {
                case 1:
                    Traverse();
                    break;
                case 2:
                    Insertion();
                    break;
                case 3:
                    Deletion();
                    break;
                case 4:
                    System.out.print("\nEnter the Item You Want to Search : ");
                    item = sc.nextInt();
                    System.out.println("\n1. Linear Searching \n2. Binary Searching");
                    System.out.print("Which Type of Searching Do You Want : ");
                    choice2 = sc.nextInt();
                    switch (choice2) {
                        case 1:
                            System.out.println("\n1. Single Linear Search \n2. Multi Linear Search");
                            System.out.print("Which Type of Linear Searching Do You Want : ");
                            choice3 = sc.nextInt();
                            switch (choice3) {
                                case 1:
                                    SingleLinearSearch();
                                    break;
                                case 2:
                                    MultiLinearSearch();
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println("\n1. Single Binary Search \n2. Multi Binary Search");
                            System.out.print("Which Type of Binary Searching Do You Want : ");
                            choice4 = sc.nextInt();
                            switch (choice4) {
                                case 1:
                                    SingleBinarySearch();
                                    break;
                                case 2:
                                    MultiBinarySearch();
                                    break;
                            }
                            break;
                    }
                    break;
                case 5:
                    System.out.println("\n1. Ascending Order \n2. Descending Order");
                    System.out.print("Which Type of Sorting Do You Want : ");
                    choice5 = sc.nextInt();
                    switch (choice5) {
                        case 1:
                            System.out.println(
                                    "\n1. Bubble Sort \n2. Selection Sort \n3. Insertion Sort \n4. Shell Sort \n5. Merge Sort \n6. Quick Sort");
                            System.out.print("Which Type of Sorting Do You Want in Ascending Order : ");
                            choice6 = sc.nextInt();
                            switch (choice6) {
                                case 1:
                                    AscendingBubbleSort();
                                    break;
                                case 2:
                                    AscendingSelectionSort();
                                    break;
                                case 3:
                                    AscendingInsertionSort();
                                    break;
                                case 4:
                                    AscendingShellSort();
                                    break;
                                case 5:
                                    AscendingMergeSort();
                                    break;
                                case 6:
                                    AscendingQuickSort();
                                    break;
                            }
                            break;
                        case 2:
                            System.out.println(
                                    "\n1. Bubble Sort \n2. Selection Sort \n3. Insertion Sort \n4. Shell Sort \n5. Merge Sort \n6. Quick Sort");
                            System.out.print("Which Type of Sorting Do You Want in Descending Order : ");
                            choice7 = sc.nextInt();
                            switch (choice7) {
                                case 1:
                                    DescendingBubbleSort();
                                    break;
                                case 2:
                                    DescendingSelectionSort();
                                    break;
                                case 3:
                                    DescendingInsertionSort();
                                    break;
                                case 4:
                                    DescendingShellSort();
                                    break;
                                case 5:
                                    DescendingMergeSort();
                                    break;
                                case 6:
                                    DescendingQuickSort();
                                    break;
                            }
                            break;
                    }
                    break;
            }
        } while (choice1 != 6);
    }

    static void ArrayMenu() {
        System.out.println("\n<========== Array Menu ==========>");
        System.out.println("1. Traverse \n2. Insertion \n3. Deletion \n4. Search \n5. Sorting \n6. Exit");
        System.out.print("Choose the Operation (1 to 6) : ");
    }

    static void Traverse() {
        if (N == 0) {
            System.out.println("\nThe Array is Empty!");
            return;
        }
        System.out.println("\nThe Elements in Array are :");

        for (int i = LB; i <= (N + LB - 1); i++) {
            System.out.println(A[i]);
        }
    }

    static void Insertion() {
        if (N == size) {
            System.out.println("\nThe Array is Full!");
            return;
        }
        System.out.print("\nEnter the Index in Which You Want to Insert : ");
        k = sc.nextInt();

        if (k < LB || k > (N + LB)) {
            System.out.println("Invalid Index Number!");
            return;
        }
        System.out.print("Enter the Item You Want to Insert : ");
        item = sc.nextInt();
        System.out.println("\nThe Array Elements Before Insertion : " + N);

        for (int i = (N + LB - 1); i >= k; i--) {
            A[i + 1] = A[i];
        }
        A[k] = item;
        N++;

        System.out.println("The Array Elements After Insertion : " + N);
    }

    static void Deletion() {
        if (N == 0) {
            System.out.println("\nThe Array is Empty!");
            return;
        }
        System.out.println("\nThe Array Elements Before Deletion : " + N);
        System.out.print("Enter Index Number You Want to Delete : ");
        k = sc.nextInt();

        if (k < LB || k > (N + LB - 1)) {
            System.out.println("Invalid Index Number!");
            return;
        }

        for (int i = k + 1; i <= (N + LB - 1); i++) {
            A[i - 1] = A[i];
        }
        N--;
        System.out.println("\nThe Array Elements After Deletion : " + N);
    }

    static void SingleLinearSearch() {
        for (int i = LB; i <= (N + LB - 1); i++) {
            if (A[i] == item) {
                System.out.println("\nItem Found.");
                return;
            }
        }
        System.out.println("Item Not Found!");
    }

    static void MultiLinearSearch() {
        int count = 0;

        for (int i = LB; i <= (N + LB - 1); i++) {
            if (A[i] == item) {
                count++;
            }
        }

        if (count == 0) {
            System.out.println(item + " Not Found!");
        } else {
            System.out.println(item + " found " + count + " times.");
        }
    }

    static void SingleBinarySearch() {
        int low = LB;
        int high = N + LB - 1;
        int mid;

        while (low <= high) {
            mid = (low + high) / 2;

            if (A[mid] == item) {
                System.out.println("Item Found.");
                return;
            } else {
                if (A[mid] < item) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        System.out.println("Item Not Found!");
    }

    static void MultiBinarySearch() {
        int low = LB;
        int high = N + LB - 1;
        int mid;
        int count = 0;

        while (low <= high) {
            mid = (low + high) / 2;

            if (A[mid] == item) {
                count++;

                int i = mid + 1;
                while (i <= high && A[i] == item) {
                    count++;
                    i++;
                }

                i = mid - 1;
                while (i >= low && A[i] == item) {
                    count++;
                    i--;
                }
                System.out.println(item + " found " + count + " times.");
                return;
            } else {
                if (A[mid] < item) {
                    low = mid + 1;
                } else {
                    high = mid - 1;
                }
            }
        }
        System.out.println(item + " Not Found!");
    }

    static void AscendingBubbleSort() {
        for (int last = (N + LB - 1); last >= (LB + 1); last--) {
            for (int i = LB; i <= last - 1; i++) {
                if (A[i] > A[i + 1]) {
                    A[i] += A[i + 1];
                    A[i + 1] = A[i] - A[i + 1];
                    A[i] -= A[i + 1];
                }
            }
        }
        System.out.println("\nAscending Bubble Sort Completed!");
    }

    static void DescendingBubbleSort() {
        for (int last = (N + LB - 1); last >= (LB + 1); last--) {
            for (int i = LB; i <= last - 1; i++) {
                if (A[i] < A[i + 1]) {
                    A[i] += A[i + 1];
                    A[i + 1] = A[i] - A[i + 1];
                    A[i] -= A[i + 1];
                }
            }
        }
        System.out.println("\nDescending Bubble Sort Completed!");
    }

    static void AscendingSelectionSort() {
        for (int first = LB; first <= (N + LB - 2); first++) {
            int minLoc = first;

            for (int i = first + 1; i <= (N + LB - 1); i++) {
                if (A[minLoc] > A[i]) {
                    minLoc = i;
                }
            }
            int temp = A[minLoc];
            A[minLoc] = A[first];
            A[first] = temp;
        }
        System.out.println("\nAscending Selection Sort Completed!");
    }

    static void DescendingSelectionSort() {
        for (int first = LB; first <= (N + LB - 2); first++) {
            int maxLoc = first;

            for (int i = first + 1; i <= (N + LB - 1); i++) {
                if (A[maxLoc] < A[i]) {
                    maxLoc = i;
                }
            }
            int temp = A[maxLoc];
            A[maxLoc] = A[first];
            A[first] = temp;
        }
        System.out.println("\nDescending Selection Sort Completed!");
    }

    static void AscendingInsertionSort() {
        for (int last = LB + 1; last <= (N + LB - 1); last++) {
            int min = A[last];
            int i = last - 1;

            while (i >= LB && A[i] > min) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = min;
        }
        System.out.println("\nAscending Insertion Sort Completed!");
    }

    static void DescendingInsertionSort() {
        for (int last = LB + 1; last <= (N + LB - 1); last++) {
            int max = A[last];
            int i = last - 1;

            while (i >= LB && A[i] < max) {
                A[i + 1] = A[i];
                i--;
            }
            A[i + 1] = max;
        }
        System.out.println("\nDescending Insertion Sort Completed!");
    }

    static void AscendingShellSort() {
        int Gap = N / 2;
        while (Gap != 0) {
            for (int Last = LB + Gap; Last <= (N + LB - 1); Last++) {
                int min = A[Last];
                int i = Last - Gap;

                while (i >= LB && A[i] > min) {
                    A[i + Gap] = A[i];
                    i -= Gap;
                }
                A[i + Gap] = min;
            }
            Gap /= 2;
        }
        System.out.println("\nAscending Shell Sort Completed!");
    }

    static void DescendingShellSort() {
        int Gap = N / 2;
        while (Gap != 0) {
            for (int Last = LB + Gap; Last <= (N + LB - 1); Last++) {
                int max = A[Last];
                int i = Last - Gap;
                while (i >= LB && A[i] < max) {
                    A[i + Gap] = A[i];
                    i -= Gap;
                }
                A[i + Gap] = max;
            }
            Gap /= 2;
        }
        System.out.println("\nDescending Shell Sort Completed!");
    }

    static void AscendingMergeSort() {
        int Low = LB;
        int High = N + LB - 1;

        AscendingMergeSort_Sub(Low, High);

        System.out.println("\nAscending Merge Sort Completed!");
    }

    static void AscendingMergeSort_Sub(int Low, int High) {
        if (Low < High) {
            int Mid = (Low + High) / 2;

            AscendingMergeSort_Sub(Low, Mid);
            AscendingMergeSort_Sub(Mid + 1, High);

            AscendingMerge(Low, Mid, High);
        }
    }

    static void AscendingMerge(int Low, int Mid, int High) {
        int NL = Mid - Low + 1;
        int NR = High - Mid;

        int[] Left = new int[NL];
        int[] Right = new int[NR];

        int k = LB;
        for (int i = Low; i <= Mid; i++) {
            Left[k] = A[i];
            k++;
        }

        k = LB;
        for (int i = Mid + 1; i <= High; i++) {
            Right[k] = A[i];
            k++;
        }

        int PTRL = LB;
        int PTRR = LB;
        int PTRA = Low;
        while (PTRL <= (NL + LB - 1) && PTRR <= (NR + LB - 1)) {
            if (Left[PTRL] < Right[PTRR]) {
                A[PTRA] = Left[PTRL];
                PTRL++;
            } else {
                A[PTRA] = Right[PTRR];
                PTRR++;
            }
            PTRA++;
        }

        if (PTRL > (NL + LB - 1)) {
            while (PTRR <= (NR + LB - 1)) {
                A[PTRA] = Right[PTRR];
                PTRR++;
                PTRA++;
            }
        } else {
            while (PTRL <= (NL + LB - 1)) {
                A[PTRA] = Left[PTRL];
                PTRL++;
                PTRA++;
            }
        }
    }

    static void DescendingMergeSort() {
        int Low = LB;
        int High = N + LB - 1;

        DescendingMergeSort_Sub(Low, High);

        System.out.println("\nDescending Merge Sort Completed!");
    }

    static void DescendingMergeSort_Sub(int Low, int High) {
        if (Low < High) {
            int Mid = (Low + High) / 2;

            DescendingMergeSort_Sub(Low, Mid);
            DescendingMergeSort_Sub(Mid + 1, High);

            DescendingMerge(Low, Mid, High);
        }
    }

    static void DescendingMerge(int Low, int Mid, int High) {
        int NL = Mid - Low + 1;
        int NR = High - Mid;

        int[] Left = new int[NL];
        int[] Right = new int[NR];

        int k = LB;
        for (int i = Low; i <= Mid; i++) {
            Left[k] = A[i];
            k++;
        }

        k = LB;
        for (int i = Mid + 1; i <= High; i++) {
            Right[k] = A[i];
            k++;
        }

        int PTRL = LB;
        int PTRR = LB;
        int PTRA = Low;
        while (PTRL <= (NL + LB - 1) && PTRR <= (NR + LB - 1)) {
            if (Left[PTRL] > Right[PTRR]) {
                A[PTRA] = Left[PTRL];
                PTRL++;
            } else {
                A[PTRA] = Right[PTRR];
                PTRR++;
            }
            PTRA++;
        }

        if (PTRL > (NL + LB - 1)) {
            while (PTRR <= (NR + LB - 1)) {
                A[PTRA] = Right[PTRR];
                PTRR++;
                PTRA++;
            }
        } else {
            while (PTRL <= (NL + LB - 1)) {
                A[PTRA] = Left[PTRL];
                PTRL++;
                PTRA++;
            }
        }
    }

    static void AscendingQuickSort() {
        int Low = LB;
        int High = N + LB - 1;

        AscendingQuickSort_Sub(Low, High);

        System.out.println("\nAscending Quick Sort Completed!");
    }

    static void AscendingQuickSort_Sub(int Low, int High) {
        if (Low < High) {
            int index = AscendingPartition(Low, High);

            AscendingQuickSort_Sub(Low, (index - 1));
            AscendingQuickSort_Sub((index + 1), High);
        }
    }

    static int AscendingPartition(int Low, int High) {
        int Pivot = A[Low];
        int i = Low + 1;
        int j = High;

        while (i <= j) {
            while ((i <= High) && (A[i] <= Pivot)) {
                i++;
            }

            while (A[j] > Pivot) {
                j--;
            }

            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } else {
                int temp = A[Low];
                A[Low] = A[j];
                A[j] = temp;
            }
        }
        return j;
    }

    static void DescendingQuickSort() {
        int Low = LB;
        int High = N + LB - 1;

        DescendingQuickSort_Sub(Low, High);

        System.out.println("\nDescending Quick Sort Completed!");
    }

    static void DescendingQuickSort_Sub(int Low, int High) {
        if (Low < High) {
            int index = DescendingPartition(Low, High);

            DescendingQuickSort_Sub(Low, (index - 1));
            DescendingQuickSort_Sub((index + 1), High);
        }
    }

    static int DescendingPartition(int Low, int High) {
        int Pivot = A[Low];
        int i = Low + 1;
        int j = High;

        while (i <= j) {
            while ((i <= High) && (A[i] >= Pivot)) {
                i++;
            }

            while (A[j] < Pivot) {
                j--;
            }

            if (i < j) {
                int temp = A[i];
                A[i] = A[j];
                A[j] = temp;
            } else {
                int temp = A[Low];
                A[Low] = A[j];
                A[j] = temp;
            }
        }
        return j;
    }
}