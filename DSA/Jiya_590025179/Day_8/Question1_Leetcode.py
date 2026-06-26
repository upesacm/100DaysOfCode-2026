class Solution:
    def isPalindrome(self, s: str) -> bool:
        l=[]
        for char in s:
            if char.isalnum():
                l.append(char.lower())
        if(l==l[::-1]):
            return True
        return False            
