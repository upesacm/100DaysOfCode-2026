import java.util.ArrayDeque;
import java.util.Deque;

public class Question1_LeetCode {
    public boolean isValid(String s) {
        Deque<Character> stack = new ArrayDeque<>();
        int len = s.length();
        if (len%2 != 0) return false;
        
        for (int i = 0; i < len; i++) {
            char ch = s.charAt(i);
            if ("({[".indexOf(ch) != -1) {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) return false;
                char ch2 = stack.peek();
                if ((ch2 == '(' && ch == ')') || (ch2 == '{' && ch == '}') || (ch2 == '[' && ch == ']')) {
                    stack.pop();
                }
                else return false;
            }
        }
        return stack.isEmpty();
    }
}
