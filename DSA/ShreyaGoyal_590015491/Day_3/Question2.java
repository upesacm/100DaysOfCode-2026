package DSA.Shreya_Goyal_590015491.Day_3;
import java.util.Scanner;

public class Question2 {

    static int countOccurrences(int[] arr, int n, int targetvalue) {

        int count = 0;

        for (int i = 0; i < n; i++) {
            if (arr[i] == targetvalue) {
                count++;
            }
        }

        return count;
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

        System.out.print("Enter target: ");
        int targetvalue = sc.nextInt();

        System.out.println("Number of occurrences: "
                + countOccurrences(arr, n, targetvalue));

        sc.close();
    }
}
