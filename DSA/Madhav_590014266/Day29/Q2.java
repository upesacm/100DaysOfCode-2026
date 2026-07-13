class Solution {
    public String reverseString(String s) {
        Stack<Character> stack = new Stack<>();

        // Push all characters onto the stack
        for (char ch : s.toCharArray()) {
            stack.push(ch);
        }

        // Pop characters to build the reversed string
        StringBuilder result = new StringBuilder();
        while (!stack.isEmpty()) {
            result.append(stack.pop());
        }

        return result.toString();
    }
}