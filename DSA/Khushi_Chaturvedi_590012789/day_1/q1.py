class Solution:
    def missingNumber(self, nums):
        n = len(nums)
        expected_sum = n * (n + 1) // 2
        actual_sum = sum(nums)
        return expected_sum - actual_sum
    
nums = [3, 0, 1]
sol = Solution()
print(sol.missingNumber(nums))
