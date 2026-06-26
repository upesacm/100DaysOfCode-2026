class Solution:
    def strStr(self, haystack: str, needle: str) -> int:
       m = len(needle)
       n = len(haystack) 
       for i in range(0, n-m+1) :
         if haystack[i:i+m] == needle :
          return i
       return -1