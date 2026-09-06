nums = list(map(int, input().split()))

max_xor = 0

for i in range(len(nums)):
    for j in range(i + 1, len(nums)):
        max_xor = max(max_xor, nums[i] ^ nums[j])

print(max_xor)