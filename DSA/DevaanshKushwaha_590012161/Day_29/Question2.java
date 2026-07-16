import java.util.Stack;
import java.util.Scanner;

public class Solution {
    public static String reverseString(String s) {
        Stack<Character> stack = new Stack<>();
        
        // push every character onto the stack
        for (char c : s.toCharArray()) {
            stack.push(c);
        }
        
        // pop characters off (LIFO order = reversed string)
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }
        
        return result.toString();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        String s = sc.nextLine();
        System.out.println(reverseString(s));
    }
}
