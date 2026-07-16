import java.util.Stack;

public class ReverseStringStack {
    public static void main(String[] args) {

        String str = "Hello";

        Stack<Character> stack = new Stack<>();

        // Push all characters
        for (char ch : str.toCharArray()) {
            stack.push(ch);
        }

        // Pop and build reversed string
        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println("Original String : " + str);
        System.out.println("Reversed String : " + reversed);
    }
}
