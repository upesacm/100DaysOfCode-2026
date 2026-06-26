def count_occurrences(arr, target):
    count = 0

    for num in arr:
        if num == target:
            count += 1

    return count

input_values = input("Enter array elements separated by spaces: ").split()

arr = []
for value in input_values:
    arr.append(int(value))

target = int(input("Enter target value: "))

result = count_occurrences(arr, target)

print("Number of occurrences =", result)