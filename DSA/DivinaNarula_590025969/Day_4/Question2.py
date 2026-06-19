def rotate_array(arr, k):
    n = len(arr)

    k = k % n

    rotated = arr[n-k:] + arr[:n-k]

    return rotated


input_values = input("Enter array elements separated by spaces: ").split()

arr = []
for value in input_values:
    arr.append(int(value))

k = int(input("Enter the value of k: "))

result = rotate_array(arr, k)
print("Rotated array:", result)