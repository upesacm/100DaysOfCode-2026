#Given an integer array and an integer k, rotate the array to the right by k steps.
#Input:nums = [1,2,3,4], k = 3. Output:[2,3,4,1]
nums = list(map(int, input("Enter the array elements: ").split()))
k = int(input("Enter k: "))
n = len(nums)
nums = nums[-k:] + nums[:-k]
print("Rotated array:", nums)