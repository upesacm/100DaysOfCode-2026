arr = list(map(int, input("Enter the array elements: ").split()))

n = len(arr)
result = [-1] * n
stack = []

# Traverse from right to left
for i in range(n - 1, -1, -1):
    while stack and stack[-1] <= arr[i]:
        stack.pop()

    if stack:
        result[i] = stack[-1]
    stack.append(arr[i])

print("Next Greater Elements:", result)