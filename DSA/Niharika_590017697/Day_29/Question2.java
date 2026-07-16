import java.util.Scanner;
import java.util.Stack;

public class Question2
{
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        String s = sc.nextLine();

        Stack<Character> stack = new Stack<>();

        // Push all characters into the stack
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters to form the reversed string
        StringBuilder reversed = new StringBuilder();

        while (!stack.isEmpty()) {
            reversed.append(stack.pop());
        }

        System.out.println(reversed);

        sc.close();
    }
}
