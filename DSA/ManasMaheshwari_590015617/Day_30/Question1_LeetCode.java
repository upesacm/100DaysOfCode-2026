class Solution {
    public String removeDuplicates(String s) {
        char[] stack = new char[s.length()];
        int top = -1;
        
        for (int i = 0; i < s.length(); i++) {
            char c = s.charAt(i);
            if (top >= 0 && stack[top] == c) {
                top--;
            } else {
                top++;
                stack[top] = c;
            }
        }
        
        char[] result = new char[top + 1];
        for (int i = 0; i <= top; i++) {
            result[i] = stack[i];
        }
        
        return new String(result);
    }
}
