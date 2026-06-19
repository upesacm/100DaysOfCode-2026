arr = [3, 7, 9, 2, 5]

largest = arr[0]

for num in arr:
    if num > largest:
        largest = num

print(largest)