class Solution(object):
    def isPalindrome(self, s):
        s = [char for char in s.lower() if char.isalnum()]
        clean_str = "".join(s)

        i, j = 0, len(clean_str) - 1
        while i < j:
            if clean_str[i] == clean_str[j]:
                i += 1
                j -= 1
            else:
                return False
        return True