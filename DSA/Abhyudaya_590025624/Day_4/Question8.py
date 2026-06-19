nums = list(map(int, input("Enter array elements: ").split()))
k = int(input("Enter k: "))

k = k % len(nums)

nums = nums[-k:] + nums[:-k]

print("Rotated array:", nums)