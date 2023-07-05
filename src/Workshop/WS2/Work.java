package Workshop.WS2;

import java.util.Arrays;
import java.util.Scanner;

public class Work {
    public static void main(String[] args) {
        // 1.
        for (int i = 2; i < 10; i++) {
            if (i % 2 == 1) {
                continue;
            }
            System.out.print(i + "; ");
        }

        // 2.
        Scanner scanner = new Scanner(System.in);
        System.out.println();
        System.out.println("\nInput data");
        System.out.print("Number of elements: ");
        int n = scanner.nextInt();
        System.out.print("\nThe elements of the arrays: ");
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = scanner.nextInt();
        }
        int choice = 0;
        do {
            System.out.println();
            System.out.println("\n==========================");
            System.out.println("1. Display all");
            System.out.println("2. Sorting");
            System.out.println("3. Find max value");
            System.out.println("4. Exit");
            System.out.print("Enter your choice: ");
            choice = scanner.nextInt();
            switch (choice) {
                case 1:
                    System.out.println("\n=======================");
                    System.out.println("Display all elements:");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + "; ");
                    }
                    break;
                case 2:
                    Arrays.sort(arr);
                    System.out.println("\n=======================");
                    System.out.println("Sorting array: ");
                    for (int i = 0; i < n; i++) {
                        System.out.print(arr[i] + "; ");
                    }
                    break;
                case 3:
                    System.out.println("\n=======================");
                    System.out.println("Max value: ");
                    Arrays.sort(arr);
                    System.out.print(arr[n-1]);
                    break;
                case 4:
                    System.out.println("Exiting. Goodbye!");
                    break;
                default:
                    System.out.println("Invalid choice. Please try again.");
            }

        } while (choice != 4);
    }
}
