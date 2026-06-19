arr = [13, 40, 23, 9, 11, 5]

largest = arr[0]

for num in arr:
    if num > largest:
        largest = num

print("Largest element is:", largest)
