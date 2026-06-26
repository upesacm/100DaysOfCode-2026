class Solution:
    def rob(self, nums):
        n = len(nums)

        if n == 1:
            return nums[0]

        def helper(left, right):
            prev2 = prev1 = 0

            for i in range(left, right + 1):
                curr = max(prev1, prev2 + nums[i])
                prev2 = prev1
                prev1 = curr

            return prev1

        return max(helper(0, n - 2), helper(1, n - 1))