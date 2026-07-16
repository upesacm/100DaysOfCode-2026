import java.util.Scanner;
import java.util.Stack;

public class Main {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.next();

        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() &&
                ((stack.peek() == 'A' && ch == 'B') ||
                 (stack.peek() == 'C' && ch == 'D'))) {
                stack.pop();   // Remove "AB" or "CD"
            } else {
                stack.push(ch);
            }
        }

        System.out.println(stack.size());
    }
}