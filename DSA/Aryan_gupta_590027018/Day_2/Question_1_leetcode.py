class Solution(object):
    def removeElement(self, nums, val):
        left = 0
        right = len(nums) - 1

        while left <= right:
            if nums[left] == val:
                nums[left] = nums[right]
                right -= 1
            else:
                left += 1

        return right + 1
       
        
