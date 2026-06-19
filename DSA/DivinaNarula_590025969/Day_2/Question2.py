def find_largest(arr):
    largest = arr[0]

    for num in arr:
        if num > largest:
            largest = num

    return largest


input_values = input("Enter array elements separated by spaces: ").split()

arr = []
for value in input_values:
    arr.append(int(value))

result = find_largest(arr)
print("Largest element =", result)