def moveZeroes(nums):
    j = 0  # Position for the next non-zero element

    for i in range(len(nums)):
        if nums[i] != 0:
            nums[j], nums[i] = nums[i], nums[j]
            j += 1


# Driver Code
nums = list(map(int, input("Enter the array elements: ").split()))

moveZeroes(nums)

print("Output:", nums)