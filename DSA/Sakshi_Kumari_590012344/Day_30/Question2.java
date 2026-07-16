import java.util.Stack;

public class Main {

    static void insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }

        int top = stack.pop();
        insertAtBottom(stack, x);
        stack.push(top);
    }

    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();

        stack.push(1);
        stack.push(2);
        stack.push(3);
        stack.push(4);

        int x = 10;

        insertAtBottom(stack, x);

        System.out.println(stack);
    }
}
