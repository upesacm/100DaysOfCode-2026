
import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    // Function to find maximum visible people
    public static int maximumVisiblePeople(int[] arr) {

        int n = arr.length;

        // Stores index of previous greater element
        int[] left = new int[n];

        // Stores index of next greater element
        int[] right = new int[n];

        Stack<Integer> stack = new Stack<>();

        // -----------------------------
        // Find Previous Greater Element
        // -----------------------------
        for (int i = 0; i < n; i++) {

            // Remove all smaller or equal heights
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // If no greater element exists
            if (stack.isEmpty()) {
                left[i] = -1;
            } else {
                left[i] = stack.peek();
            }

            // Push current index
            stack.push(i);
        }

        // Clear stack for next greater element
        stack.clear();

        // --------------------------
        // Find Next Greater Element
        // --------------------------
        for (int i = n - 1; i >= 0; i--) {

            // Remove all smaller or equal heights
            while (!stack.isEmpty() && arr[stack.peek()] <= arr[i]) {
                stack.pop();
            }

            // If no greater element exists
            if (stack.isEmpty()) {
                right[i] = n;
            } else {
                right[i] = stack.peek();
            }

            // Push current index
            stack.push(i);
        }

        // Find maximum visible people
        int maxVisible = 0;

        for (int i = 0; i < n; i++) {

            // People visible including current person
            int visible = right[i] - left[i] - 1;

            if (visible > maxVisible) {
                maxVisible = visible;
            }
        }

        return maxVisible;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        // Input array size
        System.out.print("Enter number of people: ");
        int n = sc.nextInt();

        int[] arr = new int[n];

        // Input heights
        System.out.println("Enter heights:");

        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        // Find answer
        int answer = maximumVisiblePeople(arr);

        // Print result
        System.out.println("Maximum Visible People = " + answer);

        sc.close();
    }
}
