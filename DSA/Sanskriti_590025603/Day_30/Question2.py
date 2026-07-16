def insertBottom(stack, x):
    temp = []

    while stack:
        temp.append(stack.pop())

    stack.append(x)

    while temp:
        stack.append(temp.pop())

    return stack


stack = list(map(int, input().split()))
x = int(input())

print(insertBottom(stack, x))