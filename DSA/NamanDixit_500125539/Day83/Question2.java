import java.util.Scanner;

public class Question2 {

    // Function to count the number of set bits (1s)
    static int countSetBits(int n) {

        // This variable will store the number of 1s
        int count = 0;

        // Keep checking until all bits have been checked
        while (n > 0) {

            // Check the last bit of n
            //
            // n & 1 gives:
            // 0 -> last bit is 0
            // 1 -> last bit is 1
            if ((n & 1) == 1) {

                // If the last bit is 1,
                // increase the count
                count++;
            }

            // Right shift n by 1 position
            //
            // This removes the last bit
            // and brings the next bit to the last position
            n = n >> 1;
        }

        // Return the total number of 1s
        return count;
    }

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user to enter a number
        System.out.print("Enter a non-negative integer: ");

        // Take input from the user
        int n = sc.nextInt();

        // Call the function
        int result = countSetBits(n);

        // Print the answer
        System.out.println("Number of set bits = " + result);

        // Close the Scanner
        sc.close();
    }
}