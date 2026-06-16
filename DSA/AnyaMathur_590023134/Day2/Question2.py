# question 2

nums = list(map(int, input("Enter numbers separated by spaces: ").split()))
largest = nums[0]

for num in nums:
    if num > largest:
        largest = num

print("Largest element =", largest)