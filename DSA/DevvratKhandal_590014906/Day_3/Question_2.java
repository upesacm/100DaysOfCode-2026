import java.util.Scanner;

public class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        System.out.println("Enter array elements:");
        for(int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        System.out.print("Enter target element: ");
        int target = sc.nextInt();

        int count = 0;

        for(int i = 0; i < n; i++) {
            if(arr[i] == target) {
                count++;
            }
        }

        System.out.println("Number of occurrences: " + count);

        sc.close();
    }
}