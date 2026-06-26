class Solution:
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]

        def rob_helper(houses):
            prev1 = 0
            prev2 = 0

            for money in houses:
                temp = max(prev1, prev2 + money)
                prev2 = prev1
                prev1 = temp

            return prev1

        return max(
            rob_helper(nums[:-1]),
            rob_helper(nums[1:])
        )


# Driver Code
if __name__ == "__main__":
    nums = [2, 3, 2]

    sol = Solution()
    print("Maximum amount robbed:", sol.rob(nums))