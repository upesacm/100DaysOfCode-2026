class Solution:
    def sortedSquares(self, nums):
        left = 0
        right = len(nums) - 1
        result = [0] * len(nums)
        pos = len(nums) - 1
        
        while left <= right:
            left_sq = nums[left] * nums[left]
            right_sq = nums[right] * nums[right]
            
            if left_sq >= right_sq:
                result[pos] = left_sq
                left += 1
            else:
                result[pos] = right_sq
                right -= 1
            
            pos -= 1
        
        return result