import java.util.*;

public class Main {

    public static Stack<Integer> copyStack(Stack<Integer> st) {

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        // Move original -> temp
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        // Restore original and create copy
        while (!temp.isEmpty()) {
            int x = temp.pop();
            st.push(x);
            copy.push(x);
        }

        return copy;
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        Stack<Integer> st = new Stack<>();

        System.out.print("Enter number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter stack elements:");

        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        Stack<Integer> copiedStack = copyStack(st);

        System.out.println("Original Stack: " + st);
        System.out.println("Copied Stack: " + copiedStack);
    }
}
