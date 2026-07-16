def insert_at_bottom(stack, x):
    if not stack:
        stack.append(x)
        return
    
    temp = stack.pop()
    insert_at_bottom(stack,x)
    stack.append(temp)