class Solution(object):
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]

        def rob_line(houses):
            prev1 = 0
            prev2 = 0

            for money in houses:
                temp = max(prev1, prev2 + money)
                prev2 = prev1
                prev1 = temp

            return prev1

        return max(rob_line(nums[:-1]), rob_line(nums[1:]))


# Example
nums = [1, 2, 3, 1]

sol = Solution()
print(sol.rob(nums))