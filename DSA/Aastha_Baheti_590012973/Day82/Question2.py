class Solution:
    def turnOffRightmostSetBit(self, n):
        return n & (n - 1)