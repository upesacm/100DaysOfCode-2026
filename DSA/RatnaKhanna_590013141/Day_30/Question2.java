import java.util.*;

public class Main {

    static void insertAtBottom(Stack<Integer> st, int x) {
        if (st.isEmpty()) {
            st.push(x);
            return;
        }

        int top = st.pop();
        insertAtBottom(st, x);
        st.push(top);
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        Stack<Integer> st = new Stack<>();

        System.out.print("Enter the number of elements: ");
        int n = sc.nextInt();

        System.out.println("Enter the stack elements:");
        for (int i = 0; i < n; i++) {
            st.push(sc.nextInt());
        }

        System.out.print("Enter the element to insert at the bottom: ");
        int x = sc.nextInt();

        insertAtBottom(st, x);

        System.out.println("Updated Stack: " + st);

        sc.close();
    }
}
