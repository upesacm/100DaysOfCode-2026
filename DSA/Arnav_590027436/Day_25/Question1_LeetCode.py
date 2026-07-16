class Solution(object):
    def triangleNumber(self, nums):
        nums.sort()
        count = 0

        for i in range(len(nums) -1, -1, -1):
            left = 0
            right = i - 1
            while left < right:
                if nums[left] + nums[right] > nums[i]:
                    count += (right - left)
                    right -= 1
                else:
                    left +=1
        
        return count