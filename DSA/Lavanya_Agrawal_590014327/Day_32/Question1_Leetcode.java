import java.util.Scanner;
import java.util.Stack;

public class Question1_Leetcode {

    public static int minLength(String s) {
        Stack<Character> stack = new Stack<>();

        for (char ch : s.toCharArray()) {
            if (!stack.isEmpty() &&
                ((stack.peek() == 'A' && ch == 'B') ||
                 (stack.peek() == 'C' && ch == 'D'))) {
                stack.pop();
            } else {
                stack.push(ch);
            }
        }

        return stack.size();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        System.out.println(minLength(s));

        sc.close();
    }
}