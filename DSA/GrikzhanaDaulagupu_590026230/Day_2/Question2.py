def find_largest(arr):
    largest = arr[0]

    for num in arr:
        if num > largest:
            largest = num

    return largest

# Example
arr = [12, 35, 1, 10, 34, 1]
print(find_largest(arr))
