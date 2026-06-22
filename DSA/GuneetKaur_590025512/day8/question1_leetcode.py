class Solution:
    def isPalindrome(self, s: str) -> bool:
        str = ""

        for ch in s:
            if ch.isalnum():
                str += ch.lower()

        return str == str[::-1]