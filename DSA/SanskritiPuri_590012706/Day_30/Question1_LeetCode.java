class Solution {
    public String removeDuplicates(String s) {
        StringBuilder stack = new StringBuilder(); // used as a stack (StringBuilder allows O(1) deleteCharAt at end)
        
        for (char c : s.toCharArray()) {
            int lastIdx = stack.length() - 1;
            if (lastIdx >= 0 && stack.charAt(lastIdx) == c) {
                // top of stack matches current char -> cancel them out
                stack.deleteCharAt(lastIdx);
            } else {
                // no match -> push current char
                stack.append(c);
            }
        }
        
        return stack.toString();
    }
}
