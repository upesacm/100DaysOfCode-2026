import java.util.Stack;

public class Solution {

    public static void main(String[] args) {

        Stack<Integer> st1 = new Stack<>();

        st1.push(1);
        st1.push(2);
        st1.push(3);
        st1.push(4);

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> st2 = new Stack<>();

        // Move to temporary stack
        while (!st1.isEmpty()) {
            temp.push(st1.pop());
        }

        // Restore original and copy
        while (!temp.isEmpty()) {
            int x = temp.pop();
            st1.push(x);
            st2.push(x);
        }

        System.out.println(st2);
    }
}