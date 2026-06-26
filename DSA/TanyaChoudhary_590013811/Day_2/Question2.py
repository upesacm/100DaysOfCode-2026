def largest_element(nums):
    max_val = nums[0]
    
    for i in range(1, len(nums)):
        if nums[i] > max_val:
            max_val = nums[i]
    
    return max_val
