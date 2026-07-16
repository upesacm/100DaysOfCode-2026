
import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    // Function to find Next Greater Element
    public static int[] nextGreaterElement(int[] arr) {

        // Size of array
        int n = arr.length;

        // Array to store answers
        int[] answer = new int[n];

        // Stack to store elements
        Stack<Integer> stack = new Stack<>();

        // Traverse from right to left
        for (int i = n - 1; i >= 0; i--) {

            // Remove all smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            // If stack becomes empty
            if (stack.isEmpty()) {
                answer[i] = -1;
            } // Otherwise top element is the answer
            else {
                answer[i] = stack.peek();
            }

            // Push current element into stack
            stack.push(arr[i]);
        }

        // Return answer array
        return answer;
    }

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

        // Call function
        int[] result = nextGreaterElement(arr);

        // Print answer
        System.out.println("Next Greater Elements:");

        for (int i = 0; i < result.length; i++) {
            System.out.print(result[i] + " ");
        }

        // Close Scanner
        sc.close();
    }
}
