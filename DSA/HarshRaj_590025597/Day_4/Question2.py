def rotate(arr, k):
    n = len(arr)
    if n == 0:
        return arr
    k = k % n

    def reverse(a, left, right):
        while left < right:
            a[left], a[right] = a[right], a[left]
            left += 1
            right -= 1

    reverse(arr, 0, n - 1)
    reverse(arr, 0, k - 1)
    reverse(arr, k, n - 1)
    return arr


arr = list(map(int, input().split(',')))
k = int(input())
result = rotate(arr, k)
print(result)