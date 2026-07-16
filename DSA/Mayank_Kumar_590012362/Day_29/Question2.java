import java.util.Stack;
public class Question2 {
    public void reverse(String s) {
        Stack<Character> st = new Stack<>();
        for (char c : s.toCharArray()) st.push(c);
        while (!st.isEmpty()) System.out.print(st.pop());
    }
}