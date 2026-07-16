n = int(input("Enter number of elements: "))
arr = list(map(int, input("Enter elements: ").split()))

for i in range(n):
    next_greater = -1
    for j in range(i + 1, n):
        if arr[j] > arr[i]:
            next_greater = arr[j]
            break
    print(next_greater, end=" ")
