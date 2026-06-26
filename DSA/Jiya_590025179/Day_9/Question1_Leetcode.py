class Solution:
    def lengthOfLastWord(self, s: str) -> int:
       a=[]
       a=s.split()
       return (len(a[-1]))
