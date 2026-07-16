import java.util.Stack;

public class Q2 {

    public static String reverseWithStack(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        
        StringBuilder reversed = new StringBuilder();
        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }
        
        return reversed.toString();
    }

    public static void main(String[] args) {
        String s = "hello";
        System.out.println("Output: " + reverseWithStack(s));
    }
}