class Solution:
    def sortColors(self, nums):
        low = 0
        high = len(nums) - 1
        mid = 0

        while mid <= high:
            if nums[mid] == 0:          # send 0 to front
                nums[low], nums[mid] = nums[mid], nums[low]
                low += 1
                mid += 1
            elif nums[mid] == 1:        # 1 is in correct place
                mid += 1
            else:                       # send 2 to back
                nums[mid], nums[high] = nums[high], nums[mid]
                high -= 1