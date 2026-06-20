class Solution(object):
    def canJump(self, nums):
        max_reach = 0
        target = len(nums) - 1
        for i in range(len(nums)):
            if i > max_reach:
                return False
            max_reach = max(max_reach, i + nums[i])
            if max_reach >= target:
                return True   
        return max_reach >= target
# Example usage:
nums = [2, 3, 1, 1, 4]
solution = Solution()
print(solution.canJump(nums))  # Output: True
