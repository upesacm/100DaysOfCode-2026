import java.util.Scanner;
import java.util.Stack;

public class Question2 {

    public static String postfixToPrefix(String postfix) {
        Stack<String> stack = new Stack<>();

        for (char ch : postfix.toCharArray()) {

            if (Character.isLetterOrDigit(ch)) {
                stack.push(String.valueOf(ch));
            } else {
                String operand2 = stack.pop();
                String operand1 = stack.pop();

                String prefix = ch + operand1 + operand2;

                stack.push(prefix);
            }
        }

        return stack.pop();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String postfix = sc.nextLine();

        System.out.println(postfixToPrefix(postfix));

        sc.close();
    }
}