nums = list(map(int, input("Enter array elements: ").split()))
val = int(input("Enter value to remove: "))

k = 0

for i in range(len(nums)):
    if nums[i] != val:
        nums[k] = nums[i]
        k += 1

print("Remaining elements count:", k)
print("Remaining array:", nums[:k])