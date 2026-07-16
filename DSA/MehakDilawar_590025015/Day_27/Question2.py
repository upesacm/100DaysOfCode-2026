#Given an integer array arr[] and two integers l and r, count the number of subarrays whose maximum element 
# lies within the range [l,r].
#Input:arr[] = [1,2,3,4,5], l = 2, r = 5. Output:14
def max_element(arr, x):
    left = 0
    ans = 0
    for right in range(len(arr)):
        if arr[right] > x:
            left = right + 1
        ans+= right - left + 1
    return ans
def count_subarrays(arr, l, r):
    return max_element(arr, r) - max_element(arr, l - 1)
arr = list(map(int, input().split()))
l, r = map(int, input().split())
print(count_subarrays(arr, l, r))