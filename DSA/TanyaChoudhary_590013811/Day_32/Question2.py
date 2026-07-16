def copyStack(st):
    temp = []
    copied = []
    while st:
        temp.append(st.pop())

        while temp:
        x = temp.pop()
        st.append(x)
        copied.append(x)

    return copied

st = [1, 2, 3, 4]
print(copyStack(st))  # [1, 2, 3, 4]
print(st)             # [1, 2, 3, 4]