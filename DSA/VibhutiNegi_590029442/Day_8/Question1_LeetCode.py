class Solution(object):
    def isPalindrome(self, s):
        a = ''.join(ch.lower() for ch in s if ch.isalnum())
        return a == a[::-1]