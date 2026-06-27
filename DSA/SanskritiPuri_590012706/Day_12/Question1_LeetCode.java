class Solution {
    public int[] numberOfLines(int[] widths, String s) {
         int lines = 1;
        int currentWidth = 0;

        for (int i = 0; i < s.length(); i++) {

            int width = widths[s.charAt(i) - 'a'];

            if (currentWidth + width <= 100) {
                currentWidth += width;
            } else {
                lines++;
                currentWidth = width;
            }
        }

        return new int[]{lines, currentWidth};
        
    }
}
