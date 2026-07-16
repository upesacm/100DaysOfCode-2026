# Next Greater Element in Array

n = int(input("Enter the number of elements: "))

print("Enter the elements:")
arr = list(map(int, input().split()))

result = [-1] * n          
stack = []                 

for i in range(n):
    while stack and arr[i] > arr[stack[-1]]:
        index = stack.pop()
        result[index] = arr[i]

    stack.append(i)

print("Next Greater Elements:")
print(*result)