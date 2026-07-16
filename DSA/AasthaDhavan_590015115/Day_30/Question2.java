import java.util.*;

public class Question2 {
    static void insertb(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }
        int temp = st.pop();
        insertb(st, x);
        st.push(temp);
    }

    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
       Scanner sc = new Scanner(System.in);
        int n = sc.nextInt();
        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }
        int x = sc.nextInt();
        insertb(st, x);
        System.out.println(st);

    }
}