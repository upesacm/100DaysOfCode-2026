class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (char ch : s.toCharArray()) {
            int w = widths[ch - 'a'];

            if (currentWidth + w <= 100) {
                currentWidth += w;
            } else {
                lines++;
                currentWidth = w;
            }
        }

        return new int[]{lines, currentWidth};
    }
}