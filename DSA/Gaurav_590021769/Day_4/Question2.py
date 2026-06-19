def rotate_array(nums, k):
    n = len(nums)
    k = k % n  # Handle cases where k > n
    nums = nums[-k:] + nums[:-k]
    return nums


# Example
nums = [1, 2, 3, 4]
k = 3

result = rotate_array(nums, k)
print(result)