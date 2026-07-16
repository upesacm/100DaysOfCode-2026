import java.util.Stack;
class Question2 {
    static void insertBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) { st.push(x); return; }
        int t = st.pop();
        insertBottom(st, x);
        st.push(t);
    }
}