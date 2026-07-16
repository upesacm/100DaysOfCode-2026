def insert_at_bottom(stack, x):
    if not stack:
        stack.append(x)
        return

    top = stack.pop()

    insert_at_bottom(stack, x)

    stack.append(top)


# Example
stack = [1, 2, 3, 4]
insert_at_bottom(stack, 5)
print(stack)

stack = [7, 8]
insert_at_bottom(stack, 1)
print(stack)
