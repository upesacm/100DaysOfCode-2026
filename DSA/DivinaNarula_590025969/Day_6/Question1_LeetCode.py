class Solution:
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]

        def robHouse(arr):
            prev1 = 0
            prev2 = 0

            for money in arr:
                temp = max(prev1, prev2 + money)
                prev2 = prev1
                prev1 = temp

            return prev1

        return max(robHouse(nums[:-1]), robHouse(nums[1:]))