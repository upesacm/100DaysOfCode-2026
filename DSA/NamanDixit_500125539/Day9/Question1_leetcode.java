class Solution {
    public int lengthOfLastWord(String s) {
        int count = 0;
        
        // Start from the end of the string
        for (int i = s.length() - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                count++; // Count characters of the last word
            } else {
                // If we already found characters and hit a space, the word is over
                if (count > 0) {
                    break;
                }
            }
        }
        return count; // Perfectly nested inside the method!
    }
}