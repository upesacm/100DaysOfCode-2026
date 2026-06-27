class Solution {

    public int[] numberOfLines(int[] widths, String s) {

        int lines = 1;
        int currentWidth = 0;

        for (int i = 0; i < s.length(); i++) {

            int letterWidth = widths[s.charAt(i) - 'a'];

            if (currentWidth + letterWidth <= 100) {
                currentWidth += letterWidth;
            } else {
                lines++;
                currentWidth = letterWidth;
            }
        }

        return new int[]{lines, currentWidth};
    }
}
