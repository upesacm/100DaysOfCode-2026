// LeetCode Problem 58: Length of Last Word

class Solution {
    public int lengthOfLastWord(String s) {
        int count = s.length();
        int length = 0;
        
        for (int i = count - 1; i >= 0; i--) {
            if (s.charAt(i) != ' ') {
                length++;
            } else if (length > 0) {
                return length;
            }
        }
        
        return length;
    }
}
