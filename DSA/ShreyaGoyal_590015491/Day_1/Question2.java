import java.util.Scanner;

public class Question2 {

    static int findSum(int[] arr, int n) {
        int sum = 0;

        for (int i = 0; i < n; i++) {
            sum += arr[i];
        }

        return sum;
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

        System.out.println("Sum of array elements: " + findSum(arr, n));

        sc.close();
    }
}