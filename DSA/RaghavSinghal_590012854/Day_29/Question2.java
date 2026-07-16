import java.util.Stack;

public class ReverseStringUsingStack {
    public static void main(String[] args) {
        String s = "hello";

        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println(reversed.toString());
    }
}