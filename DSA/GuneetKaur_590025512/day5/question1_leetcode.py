def jump(nums):
     reachmax=0
     for i in range(len(nums)):
        if i>reachmax:
            return False
        reachmax=max(reachmax,i+nums[i])
     return True

nums=list(map(int,input("Enter the array elements: ").split()))
if jump(nums):
    print("True")
else:
    print("False")
            