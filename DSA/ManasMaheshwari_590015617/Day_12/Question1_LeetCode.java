// LeetCode Problem 806: Number of Lines To Write String

class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int count = s.length();
        int lines = 1;
        int current_width = 0;
        
        for (int i = 0; i < count; i++) {
            int char_width = widths[s.charAt(i) - 'a'];
            current_width += char_width;
            
            if (current_width > 100) {
                lines++;
                current_width = char_width;
            }
        }
        
        return new int[]{lines, current_width};
    }
}
