class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWid = 0;
        
        for (char c : s.toCharArray()) {
            int charWidth = widths[c - 'a'];
            
            if (currentWid + charWidth > 100) {
                lines++;
                currentWid = charWidth;
            } else {
                currentWid += charWidth;
            }
        }
        
        return new int[]{lines, currentWid};
    }
}
