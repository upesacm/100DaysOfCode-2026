# Copy one stack to another while preserving order

def copy_stack(st):
    temp = []
    copied = []

    # Step 1: Move elements to temp (reverses order)
    while st:
        temp.append(st.pop())

    # Step 2: Move from temp to copied (restores order)
    while temp:
        copied.append(temp.pop())

    return copied


# Example
st = [1, 2, 3, 4]
copied_stack = copy_stack(st.copy())   # use copy() to keep original unchanged

print("Original Stack:", st)
print("Copied Stack:", copied_stack)