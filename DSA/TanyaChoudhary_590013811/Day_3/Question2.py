def countOccurrences(nums, target):
    count = 0
    
    for num in nums:
        if num == target:
            count += 1
    
    return count