def insert_at_bottom(stack, x):
    if not stack:
        stack.append(x)
        return

    temp = stack.pop()
    insert_at_bottom(stack, x)
    stack.append(temp)

# Main
stack = list(map(int, input("Enter stack elements (space-separated): ").split()))
x = int(input("Enter the element to insert at the bottom: "))

insert_at_bottom(stack, x)
print("Updated Stack:", stack)