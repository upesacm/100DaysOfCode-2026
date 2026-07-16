//Need to check if all brackets are properly matched

import java.util.Stack;

class Solution {

    public boolean isValid(String s) {

        Stack<Character> stack = new Stack<>();

        for (int i = 0; i < s.length(); i++) {

            char ch = s.charAt(i);

            // opening brackets go into the stack
            if (ch == '(' || ch == '{' || ch == '[') {

                stack.push(ch);

            } else {

                // nothing to match with
                if (stack.empty()) {
                    return false;
                }

                char top = stack.pop();

                // wrong opening bracket
                if ((ch == ')' && top != '(') ||
                    (ch == '}' && top != '{') ||
                    (ch == ']' && top != '[')) {

                    return false;
                }
            }
        }

        // everything should be matched by now
        return stack.empty();
    }
}