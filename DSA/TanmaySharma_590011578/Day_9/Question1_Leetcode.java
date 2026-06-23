class Solution {
    public int lengthOfLastWord(String s) {
        int index = s.length() - 1;

        while (index >= 0 && s.charAt(index) == ' ') {
            index--;
        }

        int length = 0;
        while (index >= 0 && s.charAt(index) != ' ') {
            length++;
            index--;
        }

        return length;
    }
}