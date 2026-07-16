n = int(input())
arr = list(map(int, input().split()))

ans = [-1] * n
stack = []

for i in range(n - 1, -1, -1):
    while stack and stack[-1] <= arr[i]:
        stack.pop()

    if stack:
        ans[i] = stack[-1]

    stack.append(arr[i])

print(*ans)