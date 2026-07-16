class Solution(object):
    def sortColors(self, nums):
        """
        :type nums: List[int]
        :rtype: None Do not return anything, modify nums in-place instead.
        """
        low = 0
        high = len(nums) - 1
        curr = 0

        while curr <= high:
            if nums[curr] == 0:
                nums[curr], nums[low] = nums[low], nums[curr]
                low +=1
                curr +=1
            elif nums[curr] == 2:
                nums[curr], nums[high] = nums[high], nums[curr]
                high -=1
            elif nums[curr] == 1:
                curr += 1
        
        return nums