import java.util.Scanner;

public class Question2 {

    // Function to check whether the number is 0 or a power of 2
    static boolean isPowerOfTwoOrZero(int n) {

        // If n is 0, the answer is true
        if (n == 0) {
            return true;
        }

        // A positive power of 2 has only ONE '1' in its binary form.
        //
        // Examples:
        // 1  = 0001
        // 2  = 0010
        // 4  = 0100
        // 8  = 1000
        //
        // n - 1 changes that one '1' into '0'
        // and changes all the zeros after it into '1'.
        //
        // Therefore:
        // n & (n - 1) == 0
        //
        // means n is a power of 2.

        return (n & (n - 1)) == 0;
    }

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a non-negative number: ");

        // Take the number as input
        int n = sc.nextInt();

        // Call our function
        boolean result = isPowerOfTwoOrZero(n);

        // Print the result
        System.out.println("Is the number 0 or a power of two? " + result);

        // Close the Scanner
        sc.close();
    }
}