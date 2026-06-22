class Solution:
    def rob(self, nums):
        if len(nums) == 1:
            return nums[0]

        def helper(arr):
            prev1 = 0
            prev2 = 0

            for num in arr:
                temp = max(prev1, prev2 + num)
                prev2 = prev1
                prev1 = temp

            return prev1

        return max(helper(nums[:-1]), helper(nums[1:]))


# Example
nums = [1, 2, 3, 1]
obj = Solution()
print(obj.rob(nums))
