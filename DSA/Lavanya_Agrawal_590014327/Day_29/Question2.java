import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters to build the reversed string
        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        return reversed.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(reverseString(s));

        sc.close();
    }
}