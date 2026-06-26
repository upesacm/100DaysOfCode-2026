class Solution(object):
    def strStr(self, haystack, needle):
        """
        :type haystack: str
        :type needle: str
        :rtype: int
        """
        
        h_len, n_len = len(haystack), len(needle)

        for h_ptr in range(h_len - n_len +1):
            n_ptr = 0
            while n_ptr < n_len and haystack[h_ptr + n_ptr] == needle[n_ptr]:
                n_ptr += 1
            if n_ptr == n_len:
                return h_ptr
            
        return -1