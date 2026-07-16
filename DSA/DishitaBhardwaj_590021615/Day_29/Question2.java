import java.util.Stack;

public class Question2  {
    public static void main(String[] args) {
        String s = "hello";

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        char[] arr = new char[s.length()];
        int i = 0;

        while (!stack.isEmpty()) {
            arr[i++] = stack.pop();
        }

        System.out.println(new String(arr));
    }
}