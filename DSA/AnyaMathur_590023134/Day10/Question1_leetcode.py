# leetcode problem 28
# find the index of the first occurance in a string

class Solution(object):
    def strStr(self, haystack, needle):
        for i in range(len(haystack)):
            if haystack[i:i+len(needle)] == needle:
                return i

        return -1