# leetcode problem 125 
# Vaild Palindrome

class Solution(object):
    def isPalindrome(self, s):
        first = 0
        last = len(s) - 1

        while first < last:

            if not s[first].isalnum():
                first += 1

            elif not s[last].isalnum():
                last -= 1

            elif s[first].lower() != s[last].lower():
                return False

            else:
                first += 1
                last -= 1

        return True