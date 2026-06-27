class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int currentWidth = 0;

        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];

            if (currentWidth + w > 100) {
                lines++;
                currentWidth = w;
            } else {
                currentWidth += w;
            }
        }

        return new int[]{lines, currentWidth};
    }
}
