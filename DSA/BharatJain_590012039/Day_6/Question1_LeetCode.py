class Solution(object):
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]

        def robRange(houses):
            prev1 = 0
            prev2 = 0

            for num in houses:
                temp = max(prev1, prev2 + num)
                prev2 = prev1
                prev1 = temp

            return prev1

        return max(
            robRange(nums[:-1]),
            robRange(nums[1:])
        )


nums = [2, 3, 2]

sol = Solution()
print(sol.rob(nums))