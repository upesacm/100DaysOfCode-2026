import java.util.*;

public class Main {

    static void insertAtBottom(Stack<Integer> st, int x) {

        // Base case
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        // Remove top element
        int top = st.pop();

        // Insert x at bottom
        insertAtBottom(st, x);

        // Put removed element back
        st.push(top);
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Stack<Integer> st = new Stack<>();

        // Input stack elements
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        int x = sc.nextInt();

        insertAtBottom(st, x);

        System.out.println(st);
    }
}