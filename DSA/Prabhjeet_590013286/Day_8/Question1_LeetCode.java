package Day_8;
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

            if (Character.toLowerCase(s.charAt(left))
                    != Character.toLowerCase(s.charAt(right))) {

                return false; // Characters do not match
            }

            left++;
            right--;
        }

        return true; // String is a palindrome
    }
}

//logic: use two pointers, one from start and one from end.
//Skip non-alphanumeric characters.
//Compare characters after converting them to lowercase.
//If all matching characters are equal, it is a palindrome.