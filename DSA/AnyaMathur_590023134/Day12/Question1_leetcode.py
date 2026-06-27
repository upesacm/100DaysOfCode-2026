# leetcode problem 806
# Number of Lines To Write String  

class Solution(object):
    def numberOfLines(self, widths, s):
        l = 1
        w = 0
        for i in s:
            x = widths[ord(i) - ord('a')]
            if w + x > 100:
                l += 1
                w = 0
            w += x
        return [l, w]