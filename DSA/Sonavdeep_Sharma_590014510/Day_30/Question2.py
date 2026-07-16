def insert_bottom(stack, x):
    if not stack:
        stack.append(x)
        return

    temp = stack.pop()
    insert_bottom(stack, x)
    stack.append(temp)

n = int(input())
stack = list(map(int, input().split()))
x = int(input())

insert_bottom(stack, x)

print(*stack)