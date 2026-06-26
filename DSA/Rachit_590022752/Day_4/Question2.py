def rotate(arr, k):
    n = len(arr)
    k = k % n
    arr[:] = arr[-k:] + arr[:-k]
    return arr

n = int(input("Enter the size of array: "))
arr = []

print("Enter the array elements one by one:")
for i in range(n):
    arr.append(int(input()))

k = int(input("Enter k (number of steps to rotate): "))

result = rotate(arr, k)
print("Rotated array:", result)
