arr = [1, 1, 2, 2, 2, 2]
target = 2

count = 0

for num in arr:
    if num == target:
        count += 1

print(count)