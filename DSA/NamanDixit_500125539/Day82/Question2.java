import java.util.Scanner;

public class Question2 {

    // Function to turn off the rightmost set bit
    static int turnOffRightmostBit(int n) {

        // n - 1 changes the rightmost 1 into 0
        // and changes the bits after it into 1.
        //
        // Then we use AND (&).
        //
        // n & (n - 1)
        //
        // This removes the rightmost 1 bit.
        return n & (n - 1);
    }

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a positive integer
        System.out.print("Enter a positive integer: ");

        // Take input
        int n = sc.nextInt();

        // Call the function
        int result = turnOffRightmostBit(n);

        // Print the result
        System.out.println("Result after turning off the rightmost set bit: " + result);

        // Close Scanner
        sc.close();
    }
}