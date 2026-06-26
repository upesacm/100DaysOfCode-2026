arr = list(map(int, input().split()))

maximum = arr[0]

for num in arr:
    if num > maximum:
        maximum = num

print(maximum)