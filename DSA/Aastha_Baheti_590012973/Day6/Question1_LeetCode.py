class Solution(object):
    def rob(self, nums):
        """
        :type nums: List[int]
        :rtype: int
        """
        def helper(arr):
            prev1 = prev2 = 0

            for num in arr:
                prev1, prev2 = max(prev2 + num, prev1), prev1

            return prev1

        n = len(nums)

        if n == 1:
            return nums[0]

        return max(helper(nums[:-1]), helper(nums[1:]))
        