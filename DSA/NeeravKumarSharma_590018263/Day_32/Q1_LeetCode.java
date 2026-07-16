class Solution {
    public int minLength(String s) {
        char[] chars = s.toCharArray();
        
        int write = -1; 
        
        for (int read = 0; read < chars.length; read++) {
            write++;
            chars[write] = chars[read];
            
            if (write >= 1) {
                if ((chars[write - 1] == 'A' && chars[write] == 'B') || 
                    (chars[write - 1] == 'C' && chars[write] == 'D')) {
                    
                    write -= 2;
                }
            }
        }
        
        return write + 1;
    }
}