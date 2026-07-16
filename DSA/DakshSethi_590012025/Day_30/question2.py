def insertAtBottom(stack, x):
    if not stack:
        stack.append(x)
        return

    top = stack.pop()
    insertAtBottom(stack, x)
    stack.append(top)

stack = list(map(int, input("Enter stack elements: ").split()))
x = int(input("Enter element to insert at bottom: "))

insertAtBottom(stack, x)

print(stack)