import java.util.*;
public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter no. of elements:");
        int n = sc.nextInt();
        System.out.println("Enter target element:");
        int target = sc.nextInt();
        int[] arr = new int[n];
        int c = 0;
        System.out.println("Enter array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            if (arr[i] == target) {
                c++;
            }
        }
        System.out.println("Number of occurrences = " + c);
        sc.close();
    }
}
