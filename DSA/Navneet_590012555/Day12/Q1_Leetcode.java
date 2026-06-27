class Solution {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;
        int width = 0;

        for (char c : s.toCharArray()) {
            int w = widths[c - 'a'];

            if (width + w > 100) {
                lines++;
                width = w;
            } else {
                width += w;
            }
        }

        return new int[] { lines, width };
    }
}