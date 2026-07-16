
import java.util.Stack;

class Question1_leetcode {

    public String removeDuplicates(String s) {

        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Traverse every character
        for (int i = 0; i < s.length(); i++) {

            // Current character
            char ch = s.charAt(i);

            // Remove duplicate if found
            if (!stack.isEmpty() && stack.peek() == ch) {
                stack.pop();
            } // Otherwise push it
            else {
                stack.push(ch);
            }
        }

        // Build the answer
        StringBuilder answer = new StringBuilder();

        for (char ch : stack) {
            answer.append(ch);
        }

        // Return final string
        return answer.toString();
    }
}
