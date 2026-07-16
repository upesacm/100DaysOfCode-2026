class Solution {
    public int minLength(String s) {
        Deque<Character> stack = new ArrayDeque<>(); // top of stack = end of Deque via push/pop
        
        for (char c : s.toCharArray()) {
            if (c == 'B' && !stack.isEmpty() && stack.peek() == 'A') {
                // "AB" formed with top of stack -> cancel
                stack.pop();
            } else if (c == 'D' && !stack.isEmpty() && stack.peek() == 'C') {
                // "CD" formed with top of stack -> cancel
                stack.pop();
            } else {
                // no cancellation -> push current char
                stack.push(c);
            }
        }
        
        return stack.size();
    }
}
