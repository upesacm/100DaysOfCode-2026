
nums = list(map(int, input("Enter array elements separated by spaces: ").split()))
k = int(input("Enter k: "))

n = len(nums)

if n > 0:
    k = k % n
    nums = nums[-k:] + nums[:-k]

print("Rotated array:")
print(*nums)