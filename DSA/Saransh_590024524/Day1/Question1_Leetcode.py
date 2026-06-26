class Solution:
    def missingNumber(self, nums):
        s = set(nums)
        for i in range(len(s)+1):
            if i not in nums:
                return i
