class Solution(object):
    def missingNumber(self, nums):
        self = len(nums)
        return self * (self + 1) // 2 - sum(nums)