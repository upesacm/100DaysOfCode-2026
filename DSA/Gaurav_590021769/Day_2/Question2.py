def find_largest(arr):
    largest = arr[0]

    for num in arr:
        if num > largest:
            largest = num

    return largest
arr = list(map(int, input("Enter the array elements separated by spaces: ").split()))
print("Largest element:", find_largest(arr))