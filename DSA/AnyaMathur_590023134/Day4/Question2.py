#problem 2  rotate array by k steps

array = list(map(int, input("Enter elements separated by spaces: ").split()))
k = int(input("Enter k: "))

n = len(array)
k = k % n

rotated = array[n-k:] + array[:n-k]

print("Rotated array: ", rotated)