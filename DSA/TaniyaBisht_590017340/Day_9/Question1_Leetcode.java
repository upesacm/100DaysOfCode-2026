
class Solution {
    public int lengthOfLastWord(String s) {
        String words[] = s.split(" ");
        String lastw = words[words.length - 1];
        int length = lastw.length();
        return length;
    }
}