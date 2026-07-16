class Solution {
    public boolean isValid(String s) {
        Stack<Character> stack = new Stack<>();
        
        for (char c : s.toCharArray()) {
            if (c == '(' || c == '{' || c == '[') {
                // opening bracket -> push it
                stack.push(c);
            } else {
                // closing bracket -> must match top of stack
                if (stack.isEmpty()) {
                    return false; // nothing to match with
                }
                char top = stack.pop();
                if (c == ')' && top != '(') return false;
                if (c == '}' && top != '{') return false;
                if (c == ']' && top != '[') return false;
            }
        }
        
        // valid only if every opened bracket was closed
        return stack.isEmpty();
    }
}
