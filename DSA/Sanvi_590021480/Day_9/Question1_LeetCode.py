class Solution:
    def lengthOfLastWord(self, s: str) -> int:
        a=list(map(str,s.split()))
        n=len(a)
        return len(a[n-1])
        
