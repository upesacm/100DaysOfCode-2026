package DSA.Mugdha_590015431.Day_36;
import java.util.*;

public class Question1_LeetCode {

    static class MyStack {

        Queue<Integer> q1;
        Queue<Integer> q2;

        public MyStack() {
            q1 = new LinkedList<>();
            q2 = new LinkedList<>();
        }

        public void push(int x) {
            q2.offer(x);

            while (!q1.isEmpty()) {
                q2.offer(q1.poll());
            }

            Queue<Integer> temp = q1;
            q1 = q2;
            q2 = temp;
        }

        public int pop() {
            return q1.poll();
        }

        public int top() {
            return q1.peek();
        }

        public boolean empty() {
            return q1.isEmpty();
        }
    }

    public static void main(String[] args) {

        MyStack st = new MyStack();

        st.push(1);
        st.push(2);

        System.out.println(st.top());    // 2
        System.out.println(st.pop());    // 2
        System.out.println(st.empty());  // false
    }
}