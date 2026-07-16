import java.util.Scanner;
import java.util.Stack;

public class Main {

    // Function to copy stack while preserving order
    static void copyStack(Stack<Integer> original, Stack<Integer> copy) {
        if (original.isEmpty()) {
            return;
        }

        int top = original.pop();
        copyStack(original, copy);

        original.push(top); // Restore original stack
        copy.push(top);     // Copy into new stack
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> original = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        for (int i = 0; i < n; i++) {
            original.push(sc.nextInt());
        }

        copyStack(original, copy);

        System.out.println(copy);
    }
}