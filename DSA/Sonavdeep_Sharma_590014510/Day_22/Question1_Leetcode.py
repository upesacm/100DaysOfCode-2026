class Solution:
    def moveZeroes(self, nums: List[int]) -> None:
        """
        Do not return anything, modify nums in-place instead.
        """
        non_zero_index = 0
        for current_index in range(len(nums)):
            if nums[current_index] != 0:
                nums[non_zero_index], nums[current_index] = nums[current_index], nums[non_zero_index]
                non_zero_index += 1