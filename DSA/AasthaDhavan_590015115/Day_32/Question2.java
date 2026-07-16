import java.util.Stack;

class Question2 {
    public static Stack<Integer> copyStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        while (!temp.isEmpty()) {
            int x = temp.pop();
            st.push(x);
            copy.push(x);
        }

        return copy;
    }
}