class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        n = x ^ y
        count = 0

        while n:
            n = n & (n - 1)
            count += 1

        return count