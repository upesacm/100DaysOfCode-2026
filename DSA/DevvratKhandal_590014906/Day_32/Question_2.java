import java.util.Scanner;
import java.util.Stack;

class Question_2 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> st = new Stack<>();
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> newStack = new Stack<>();

        System.out.println("Enter number of elements in stack:");
        int n = sc.nextInt();

        System.out.println("Enter stack elements:");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        // Reverse original stack into temp
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        // Copy back to both original and new stack
        while (!temp.isEmpty()) {
            int x = temp.pop();
            st.push(x);
            newStack.push(x);
        }

        System.out.println("Copied Stack: " + newStack);

        sc.close();
    }
}