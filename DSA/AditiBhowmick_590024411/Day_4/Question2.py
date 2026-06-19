nums = [1, 2, 3, 4]
k = 3

n = len(nums)
k = k % n

nums = nums[-k:] + nums[:-k]
print(nums)