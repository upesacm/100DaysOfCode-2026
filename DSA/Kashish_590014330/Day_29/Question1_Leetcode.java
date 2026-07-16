import java.util.Scanner;
import java.util.Stack;

public class Question1_Leetcode{
    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        boolean valid = true;

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);
            if (ch == '(' || ch == '{' || ch == '[') {
                stack.push(ch);
            }
            else {
                if (stack.isEmpty()) {
                    valid = false;
                    break;
                }

                char top = stack.peek();

                if ((ch == ')' && top == '(') ||
                    (ch == '}' && top == '{') ||
                    (ch == ']' && top == '[')) {

                    stack.pop();   // Matching bracket found
                } else {
                    valid = false;
                    break;
                }
            }
        }

    
        if (!stack.isEmpty()) {
            valid = false;
        }

        System.out.println(valid);
    }
}