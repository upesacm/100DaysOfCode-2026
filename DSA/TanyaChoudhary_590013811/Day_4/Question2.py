def rotateArray(nums, k):
    n = len(nums)
    k = k % n                    # handle k greater than array length
    
    result = []
    
    for i in range(n - k, n):    # pick last k elements first
        result.append(nums[i])
    
    for i in range(0, n - k):    # then pick remaining elements
        result.append(nums[i])
    
    return result