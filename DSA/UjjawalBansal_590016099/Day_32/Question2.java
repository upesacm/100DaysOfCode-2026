import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {
    public static Deque<Integer> copyStack(Deque<Integer> stack) {
        Deque<Integer> ans = new ArrayDeque<>();
        Deque<Integer> tempStack = new ArrayDeque<>();

        while (!stack.isEmpty()) {
            int val = stack.pop();
            tempStack.push(val);
        }

        while (!tempStack.isEmpty()) {
            int val = tempStack.pop();
            ans.push(val);
            stack.push(val);
        }
        return ans;
    }

    public static void main (String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the number of elements in the stack: ");
        int n = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        System.out.println("Enter the elements of the stack (from bottom to top): ");
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        Deque<Integer> output = copyStack(stack);
        System.out.println("Original stack (from bottom to top): " + stack.reversed());
        System.out.println("Copied stack (from bottom to top): " + output.reversed());
        sc.close();
    }
}