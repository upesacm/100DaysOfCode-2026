from collections import deque

def copyStack(st):
    temp = deque()
    newStack = deque()

    while st:
        temp.append(st.pop())

    while temp:
        x = temp.pop()
        st.append(x)
        newStack.append(x)

    return newStack


st = deque([1, 2, 3, 4])

newStack = copyStack(st)

print(list(newStack))
