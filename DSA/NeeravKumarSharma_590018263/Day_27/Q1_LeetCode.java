class Solution {
    public int compress(char[] chars) {
        int read = 0;
        int write = 0;
        
        while (read < chars.length) {
            char currentChar = chars[read];
            int count = 0;
            
            while (read < chars.length && chars[read] == currentChar) {
                read++;
                count++;
            }
            
            chars[write] = currentChar;
            write++;
            
            if (count > 1) {
                for (char c : String.valueOf(count).toCharArray()) {
                    chars[write] = c;
                    write++;
                }
            }
        }
        
        return write;
    }
}