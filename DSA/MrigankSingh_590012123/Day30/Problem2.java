import java.util.Stack;

public class Problem2 {
    public Stack<Integer> insertAtBottom(Stack<Integer> stack, int x) {
        if (stack.isEmpty()) {
            stack.push(x);
            return stack;
        }

        int top = stack.pop();
        insertAtBottom(stack, x);
        stack.push(top);
        return stack;
    }
}