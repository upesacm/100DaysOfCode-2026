class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
        window = len(needle)
        for right in range(len(haystack)-window+1):
            if haystack[right : window+right] == needle:
                return right

        return -1        
        