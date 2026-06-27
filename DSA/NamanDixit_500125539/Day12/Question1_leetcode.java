
class Question1_leetcode {
    public int[] numberOfLines(int[] widths, String s) {
        int lines = 1;         // Start on the first line
        int currentWidth = 0;  // Track the current pixel width of the active line

        for (int i = 0; i < s.length(); i++) {
            // Find the pixel width of the current character
            int charWidth = widths[s.charAt(i) - 'a'];

            // Check if adding this character exceeds the 100-pixel limit
            if (currentWidth + charWidth > 100) {
                lines++;                // Move to a new line
                currentWidth = charWidth; // The current character starts the new line
            } else {
                currentWidth += charWidth; // It fits, just add it to the current line
            }
        }

        return new int[]{lines, currentWidth};
    }
}