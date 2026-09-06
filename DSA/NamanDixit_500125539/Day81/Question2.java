import java.util.Scanner;

public class Question2 {

    // Function to find the number that appears only once
    static int findUnique(int[] nums) {

        // This will store our final answer
        int answer = 0;

        // An integer has 32 bits
        // So we check each bit position from 0 to 31
        for (int bit = 0; bit < 32; bit++) {

            // Count how many numbers have 1
            // at the current bit position
            int count = 0;

            // Check every number in the array
            for (int num : nums) {

                // Move the required bit to the last position
                // and check whether it is 1
                //
                // Example:
                // num = 5  -> 0101
                // bit = 0
                //
                // 0101 >> 0 = 0101
                // Last bit is 1
                if (((num >> bit) & 1) == 1) {
                    count++;
                }
            }

            // Every repeated number appears 3 times.
            //
            // Therefore, the count of 1s at this bit
            // should be a multiple of 3.
            //
            // If there is a remainder of 1,
            // the unique number has a 1 at this position.
            if (count % 3 == 1) {

                // Put a 1 at this bit position in our answer
                answer = answer | (1 << bit);
            }
        }

        // Return the unique number
        return answer;
    }

    public static void main(String[] args) {

        // Scanner is used to take input from the user
        Scanner sc = new Scanner(System.in);

        // Ask the user for the size of the array
        System.out.print("Enter the size of the array: ");

        // Take array size as input
        int n = sc.nextInt();

        // Create the array
        int[] nums = new int[n];

        // Take all array elements from the user
        System.out.println("Enter the array elements:");

        for (int i = 0; i < n; i++) {
            nums[i] = sc.nextInt();
        }

        // Find the number that appears only once
        int result = findUnique(nums);

        // Print the answer
        System.out.println("The unique number is: " + result);

        // Close Scanner
        sc.close();
    }
}