/*Find the Index of the First Occurrence in a String
Explanation
Find the starting index of a substring within a string. */

class Solution {
    public int strStr(String haystack, String needle) {
        int n1 = haystack.length();
        int n2 = needle.length();
        int i, j;

        for(i = 0; i <= n1 - n2; i++){
            j = 0;
            while(j < n2 && haystack.charAt(i + j) == needle.charAt(j)){
                j++;
            }

            if(j == n2){
                return i;
            }
        }

        return -1;
    }
}