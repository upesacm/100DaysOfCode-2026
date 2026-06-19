def count_occurrences(arr, target):
    count = 0
    for num in arr:
        if num == target:
            count += 1
    return count

arr = list(map(int, input("Enter the array: ").split()))

target = int(input("Enter the target value: "))

result = count_occurrences(arr, target)
print("Number of occurrences of", target, ":", result)
