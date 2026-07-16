
import java.util.Scanner;

public class Question2 {

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Input size of array
        System.out.print("Enter size of array: ");
        int n = sc.nextInt();

        // Create array
        int[] arr = new int[n];

        // Input array elements
        System.out.println("Enter array elements:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Input left boundary
        System.out.print("Enter l: ");
        int l = sc.nextInt();

        // Input right boundary
        System.out.print("Enter r: ");
        int r = sc.nextInt();

        // Call function
        int answer = countSubarrays(arr, l, r);

        // Print answer
        System.out.println("Number of Valid Subarrays = " + answer);

        // Close Scanner
        sc.close();
    }

    // Function to count valid subarrays
    public static int countSubarrays(int[] arr, int l, int r) {

        // Store final answer
        int count = 0;

        // Index of last element greater than r
        int lastInvalid = -1;

        // Index of last element between l and r
        int lastValid = -1;

        // Traverse the array
        for (int i = 0; i < arr.length; i++) {

            // If current element is greater than r
            // Every subarray including this element becomes invalid
            if (arr[i] > r) {
                lastInvalid = i;
            }

            // If current element is inside the range
            // Update last valid position
            if (arr[i] >= l && arr[i] <= r) {
                lastValid = i;
            }

            // Count valid subarrays ending at index i
            if (lastValid > lastInvalid) {
                count = count + (lastValid - lastInvalid);
            }
        }

        // Return answer
        return count;
    }
}
