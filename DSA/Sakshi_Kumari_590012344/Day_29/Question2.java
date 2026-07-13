import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        String s = "hello";
        Stack<Character> st = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            st.push(s.charAt(i));
        }
        while (!st.isEmpty()) {
            System.out.print(st.pop());
        }
    }
}
