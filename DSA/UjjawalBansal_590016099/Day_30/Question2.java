import java.util.ArrayDeque;
import java.util.Deque;
import java.util.Scanner;

public class Question2 {
    public static void bottomInsertion(Deque<Integer> stack, int x) {
        Deque<Integer> tempStack = new ArrayDeque<>();
        while (!stack.isEmpty()) {
            tempStack.push(stack.pop());
        }

        stack.push(x);
        while (!tempStack.isEmpty()) {
            stack.push(tempStack.pop());
        }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the current number of elements in the stack:");
        int n = sc.nextInt();

        Deque<Integer> stack = new ArrayDeque<>();
        System.out.println("Enter the elements of the stack from bottom to top");
        
        for (int i = 0; i < n; i++) {
            stack.push(sc.nextInt());
        }

        System.out.println("Enter the element to be inserted at the bottom of the stack: ");
        int x = sc.nextInt();

        bottomInsertion(stack, x);
        System.out.println("Stack after insertion(bottom to top): " + stack.reversed());
        sc.close();
    }
}
