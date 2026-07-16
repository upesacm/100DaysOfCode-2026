def insertAtBottom(stack, x):
    temp = []
    
    while stack:
        temp.append(stack.pop())
    
    stack.append(x)
    
    while temp:
        stack.append(temp.pop())
    
    print(stack)

stack = [5, 4, 3, 2, 1]
insertAtBottom(stack, 0)