def count_occurrences(arr, target):
    count = 0

    for num in arr:
        if num == target:
            count += 1

    return count


# Example
arr = [1, 1, 2, 2, 2, 2]
target = 2

result = count_occurrences(arr, target)
print(result)