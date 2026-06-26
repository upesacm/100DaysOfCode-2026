class Solution {
    public int strStr(String haystack, String needle) {
        for(int i = 0; i <= haystack.length() - needle.length(); i++) {
            String temp = "";
            for(int j = i; j < i + needle.length(); j++) {
                temp += haystack.charAt(j);
            }
            if(temp.equals(needle)) {
                return i;
            }
        }
        return -1;
    }
}