def rotate(nums , k):
    n = len(nums)
    k = k % n
    return nums[-k:] + nums[:-k]

nums = [1,2,3,4]
k =3
print(rotate(nums, k))