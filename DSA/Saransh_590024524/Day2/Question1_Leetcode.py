class Solution:
    def removeElement(self, nums, val: int) -> int:
        if not nums:
            return 0

        left = 0
        for right in range(len(nums)):
            if nums[right] != val:
                nums[left] = nums[right]
                left+=1

        return left 
    