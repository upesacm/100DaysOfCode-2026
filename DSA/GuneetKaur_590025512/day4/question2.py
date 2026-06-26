n = int(input("Enter size of array: "))

arr = list(map(int, input("Enter array elements: ").split()))

k = int(input("Enter k: "))

k = k % n

rotated = arr[-k:] + arr[:-k]

print("Rotated array:", rotated)