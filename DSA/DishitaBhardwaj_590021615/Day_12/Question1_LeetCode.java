class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (char ch : s.toCharArray()) {
            int width = widths[ch - 'a'];

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
