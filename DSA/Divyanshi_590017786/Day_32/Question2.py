def copy_stack(st):
    temp = []
    copied = []


    while st:
        temp.append(st.pop())


    while temp:
        x = temp.pop()
        st.append(x)
        copied.append(x)

    return copied


# Input
st = list(map(int, input().split()))

# Output
print(copy_stack(st))
