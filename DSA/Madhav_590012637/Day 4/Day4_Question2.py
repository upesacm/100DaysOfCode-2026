nums = [1,2,3,4,5,6,7]
k = 3

n = len(nums)
k = k % n

for i in range(k):
    last = nums[-1]

    for j in range(n-1,0,-1):
        nums[j] = nums[j-1]

    nums[0] = last

print(nums)