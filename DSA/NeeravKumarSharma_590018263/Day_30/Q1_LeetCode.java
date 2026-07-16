class Solution {
    public String removeDuplicates(String s) {
        char[] chars = s.toCharArray();
        
        int write = -1; 
        
        for (int read = 0; read < chars.length; read++) {
            if (write >= 0 && chars[write] == chars[read]) {
                write--;
            } else {
                write++;
                chars[write] = chars[read];
            }
        }
        
        return new String(chars, 0, write + 1);
    }
}