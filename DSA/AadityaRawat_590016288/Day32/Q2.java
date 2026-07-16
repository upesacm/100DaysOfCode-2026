import java.util.Stack;

public class Q2 {

    public static Stack<Integer> copyStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();

        while (!st.isEmpty()) {
            temp.push(st.pop());
        }

        while (!temp.isEmpty()) {
            int val = temp.pop();
            st.push(val);
            copy.push(val);
        }

        return copy;
    }

    public static void printStack(Stack<Integer> s) {
        System.out.println(s);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        st.push(1);
        st.push(2);
        st.push(3);
        st.push(4);

        Stack<Integer> copy = copyStack(st);

        printStack(copy);
    }
}