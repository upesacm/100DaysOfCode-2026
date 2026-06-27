class Solution:
    def lengthOfLastWord(self, s):
        s = s[::-1]
        i = 0
        while i < len(s) and s[i] == ' ':
            i += 1
        length = 0
        while i < len(s) and s[i] != ' ':
            length += 1
            i += 1
        return length