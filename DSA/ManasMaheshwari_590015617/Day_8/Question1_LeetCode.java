// LeetCode Problem 125: Valid Palindrome

class Solution {
    public boolean isPalindrome(String s) {
        String cleaned_s = s.replaceAll("[^a-zA-Z0-9]", "").toLowerCase(); 
        int count = cleaned_s.length();

        for (int i = 0; i < count / 2; i++) {
            if (cleaned_s.charAt(i) != cleaned_s.charAt(count - 1 - i)) {
                return false;
            }
        }
        
        return true;
    }
}
