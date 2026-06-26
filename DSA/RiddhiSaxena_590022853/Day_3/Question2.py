def count_occurrences(arr, target):
    first = -1
    last = -1

    # Find first occurrence
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            first = mid
            right = mid - 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    # Find last occurrence
    left, right = 0, len(arr) - 1
    while left <= right:
        mid = (left + right) // 2

        if arr[mid] == target:
            last = mid
            left = mid + 1
        elif arr[mid] < target:
            left = mid + 1
        else:
            right = mid - 1

    if first == -1:
        return 0

    return last - first + 1


# Example
arr = [1, 1, 2, 2, 2, 4, 5]
target = 2

print(count_occurrences(arr, target))