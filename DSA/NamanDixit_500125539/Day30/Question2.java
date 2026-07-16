
import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    // Function to insert an element at the bottom of the stack
    public static void insertAtBottom(Stack<Integer> stack, int x) {

        // Base Case:
        // If stack is empty, insert x
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        // Remove the top element
        int top = stack.pop();

        // Recursively insert x into the remaining stack
        insertAtBottom(stack, x);

        // Push the removed element back
        stack.push(top);
    }

    public static void main(String[] args) {

        // Create Scanner object
        Scanner sc = new Scanner(System.in);

        // Create Stack
        Stack<Integer> stack = new Stack<>();

        // Input number of elements
        System.out.print("Enter number of elements in stack: ");
        int n = sc.nextInt();

        // Input stack elements
        System.out.println("Enter stack elements:");

        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        // Input element to insert at bottom
        System.out.print("Enter element to insert at bottom: ");
        int x = sc.nextInt();

        // Call function
        insertAtBottom(stack, x);

        // Print updated stack
        System.out.println("Updated Stack = " + stack);

        // Close Scanner
        sc.close();
    }
}
