package DSA.TanmaySharma_590011578.Day_33;
import java.util.Scanner;
import java.util.Stack;

public class Question2 {
    public static boolean isOperator(char ch) {
        if (ch == '+' || ch == '-' || ch == '*' || ch == '/') {
            return true;
        }
        return false;
    }

    public static String postfixToPrefix(String s) {
        Stack<String> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {
            char ch = s.charAt(i);

            if (isOperator(ch)) {
                String operand2 = stack.pop();
                String operand1 = stack.pop();
                String expression = ch + operand1 + operand2;
                stack.push(expression);
            } else {
                stack.push(String.valueOf(ch));
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner scanner = new Scanner(System.in);
        String s = scanner.nextLine();

        String result = postfixToPrefix(s);
        System.out.println(result);

        scanner.close();
    }
}