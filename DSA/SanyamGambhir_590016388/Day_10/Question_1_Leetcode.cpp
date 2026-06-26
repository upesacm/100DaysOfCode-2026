class Solution {
public:
    int strStr(string haystack, string needle) {
        int n = haystack.length();
        int m = needle.length();
        
        if (m == 0) return 0;
        
        // 1. Build LPS array
        vector<int> lps(m, 0);
        int len = 0;
        int idx = 1;
        while (idx < m) {
            if (needle[idx] == needle[len]) {
                len++;
                lps[idx] = len;
                idx++;
            } else {
                if (len != 0) {
                    len = lps[len - 1];
                } else {
                    lps[idx] = 0;
                    idx++;
                }
            }
        }
        
        // 2. Perform KMP Search
        int i = 0; // haystack pointer
        int j = 0; // needle pointer
        while (i < n) {
            if (haystack[i] == needle[j]) {
                i++;
                j++;
            }
            
            if (j == m) {
                return i - j;
            } else if (i < n && haystack[i] != needle[j]) {
                if (j != 0) {
                    j = lps[j - 1];
                } else {
                    i++;
                }
            }
        }
        
        return -1;
    }
};