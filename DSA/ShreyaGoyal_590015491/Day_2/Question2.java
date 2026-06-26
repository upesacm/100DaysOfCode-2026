package DSA.ShreyaGoyal_590015491.Day_2;

import java.util.Scanner;

public class Question2 {

    static int findLargest(int[] arr, int n) {
        int largest = arr[0];

        for (int i = 1; i < n; i++) {
            if (arr[i] > largest) {
                largest = arr[i];
            }
        }

        return largest;
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.print("Enter array elements: ");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.println("Largest element is: " + findLargest(arr, n));

        sc.close();
    }
}