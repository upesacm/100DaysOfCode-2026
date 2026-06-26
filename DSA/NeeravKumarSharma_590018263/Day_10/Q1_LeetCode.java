class Solution {
    public int strStr(String haystack, String needle) {
        int hLen = haystack.length();
        int nLen = needle.length();
        
        if (hLen < nLen) {
            return -1;
        }
        
        for (int i = 0; i <= hLen - nLen; i++) {
            int j = 0;
            
            while (j < nLen && haystack.charAt(i + j) == needle.charAt(j)) {
                j++;
            }
            
            if (j == nLen) {
                return i;
            }
        }
        
        return -1;
    }
}