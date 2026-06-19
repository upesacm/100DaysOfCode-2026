nums = list(map(int, input("Enter array elements: ").split()))

max_reach = 0

for i in range(len(nums)):
    if i > max_reach:
        print(False)
        break

    max_reach = max(max_reach, i + nums[i])

else:
    print(True)