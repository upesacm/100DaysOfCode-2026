# Number of 1 Bits

class Solution(object):
    def hammingWeight(self, n):
        count = 0

        while n:
            n = n & (n - 1)
            count += 1

        return count