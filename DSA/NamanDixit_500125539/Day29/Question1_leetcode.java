import java.util.Stack;

class Question1_leetcode {

    public boolean isValid(String s) {

        // Create a stack
        Stack<Character> stack = new Stack<>();

        // Traverse the string
        for (int i = 0; i < s.length(); i++) {

            // Current character
            char ch = s.charAt(i);

            // Push opening brackets
            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);
            }

            // Closing bracket
            else {

                // Stack is empty
                if (stack.isEmpty()) {
                    return false;
                }

                // Pop top element
                char top = stack.pop();

                // Check matching brackets
                if (ch == ')' && top != '(') {
                    return false;
                }

                if (ch == '}' && top != '{') {
                    return false;
                }

                if (ch == ']' && top != '[') {
                    return false;
                }
            }
        }

        // Return true if stack becomes empty
        return stack.isEmpty();
    }
}