// LeetCode Problem 28: Find the Index of the First Occurrence in a String

class Solution {
    public int strStr(String haystack, String needle) {

        for(int i = 0, j = needle.length(); j<=haystack.length(); i++,j++){
            
            if(haystack.substring(i,j).equals(needle)){
                return i;
            }
        }
        return -1;
    }
}
