class Solution(object):
    def isPalindrome(self, s):
        """
        :type s: str
        :rtype: bool
        """
        s=s.lower()
        x=""
        for i in range(len(s)):
            if s[i].isalnum():
                x+=s[i]
        return x[::-1]==x