class Solution {
    public boolean isPalindrome(String s) {
        int left = 0;
        int right = s.length() - 1;

        while (left < right) {

            while (left < right && !Character.isLetterOrDigit(s.charAt(left))) {
                left++;
            }

            while (left < right && !Character.isLetterOrDigit(s.charAt(right))) {
                right--;
            }

            char ch1 = Character.toLowerCase(s.charAt(left));
            char ch2 = Character.toLowerCase(s.charAt(right));

            if (ch1 != ch2) {
                return false;
            }

            left++;
            right--;
        }

        return true;
    }
}
