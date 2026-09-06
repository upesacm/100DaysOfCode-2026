import java.util.Scanner;

public class Question2 {

    public static int findSingleNumber(int[] nums) {
        // 'result' holds the running XOR of all numbers seen so far.
        // Start at 0 because XOR-ing with 0 doesn't change anything.
        int result = 0;

        // Loop through every number in the array
        for (int num : nums) {
            // XOR the current number into our running result.
            // - If a number appears twice, its two XOR operations cancel out (a ^ a = 0)
            // - The single (unpaired) number will remain because it's only XORed once
            result = result ^ num;
        }

        // After processing all numbers, only the unpaired number is left
        return result;
    }

    public static void main(String[] args) {
        // Scanner reads input typed by the user from the console
        Scanner scanner = new Scanner(System.in);

        // Ask the user how many numbers they want to enter
        System.out.print("Enter the number of elements in the array: ");
        int n = scanner.nextInt();

        // Create an array of that size to store the user's numbers
        int[] nums = new int[n];

        // Ask the user to type each number one by one
        System.out.println("Enter " + n + " integers (every number should repeat twice, except one):");
        for (int i = 0; i < n; i++) {
            nums[i] = scanner.nextInt();
        }

        // Run our XOR logic on the array the user entered
        int answer = findSingleNumber(nums);

        // Display the result
        System.out.println("The element that appears once is: " + answer);

        // Always close the scanner when done to free up resources
        scanner.close();
    }
}