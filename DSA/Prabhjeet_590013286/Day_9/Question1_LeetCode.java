class Solution {

    public int lengthOfLastWord(String s) {

        int len = 0;

        int i = s.length() - 1;

        while (i >= 0 && s.charAt(i) == ' ') {

            i--; // Skip trailing spaces
        }

        while (i >= 0 && s.charAt(i) != ' ') {

            len++;
            i--;
        }

        return len; // Length of last word
    }
}

//logic: start from the end of the string.
//Ignore trailing spaces first.
//Count characters until a space is found.
//The count is the length of the last word.