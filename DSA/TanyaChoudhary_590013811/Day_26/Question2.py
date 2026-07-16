def tripletSumCheck(nums):
    nums.sort()
    
    for i in range(len(nums) - 1, 1, -1):
        left = 0
        right = i - 1
        
        while left < right:
            if nums[left] + nums[right] == nums[i]:
                return True
            elif nums[left] + nums[right] < nums[i]:
                left += 1
            else:
                right -= 1
    
    return False





