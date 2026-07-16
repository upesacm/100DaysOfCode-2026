import java.util.Stack;

public class Question2 {

    public static Stack<Integer> copyStack(Stack<Integer> st) {
        Stack<Integer> newStack = new Stack<>();

        copy(st, newStack);
        return newStack;
    }

    private static void copy(Stack<Integer> st, Stack<Integer> newStack) {
        if (st.isEmpty()) return;
        int top = st.pop();
        copy(st, newStack); 
        newStack.push(top); 
        st.push(top); 
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        Stack<Integer> result = copyStack(st);

        System.out.println("Original: " + st);
        System.out.println("Copied: " + result);
    }
}