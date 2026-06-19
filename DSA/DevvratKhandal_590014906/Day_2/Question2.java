import java.util.Scanner;

public class Question2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();
        int[] arr = new int[n];

        int actualSum = 0;

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
            actualSum += arr[i];
        }

        int expectedSum = n * (n + 1) / 2;
        //We used n * (n + 1) / 2 to calculate the expected sum of the first n natural numbers.
        System.out.println("Missing number is: ");
        System.out.println(expectedSum - actualSum);
/*Missing number is expectedSum - actualSum because Because the expected 
includes all numbers from 0 to n, while the actual sum is missing one number*/
        sc.close();
    }
}