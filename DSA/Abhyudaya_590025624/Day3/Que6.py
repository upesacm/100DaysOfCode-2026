arr = list(map(int, input("Enter sorted array elements: ").split()))

target = int(input("Enter target: "))

count = 0

for i in arr:
    if i == target:
        count += 1

print("Occurrences =", count)#day3 completed ` abhyudaya 590025624`