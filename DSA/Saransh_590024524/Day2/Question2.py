nums = list(map(int,input("Enter elements of the array separated by space: ").split()))

maxx = nums[0]
for i in nums:
    if i > maxx:
        maxx = i
        
print("The largest element in the array is:", maxx)        
