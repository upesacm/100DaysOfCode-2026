import java.util.*;

public class Question2 {
    public static String reverseUsingStack(String s) {
        Stack<Character> stack = new Stack<>();
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        return result.toString();
    }
    public static void main(String[] args) {
        String s = "hello";
        System.out.println(reverseUsingStack(s));
    }
}