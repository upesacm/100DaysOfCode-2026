import java.util.Scanner;
import java.util.Stack;

class Question_1 {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.println("Enter the string:");
        String s = sc.nextLine();

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

        System.out.println("Minimum length after removing substrings: " + stack.size());

        sc.close();
    }
}