def next_greater(arr):
    res, st = [-1] * len(arr), []
    for i in range(len(arr) - 1, -1, -1):
        while st and st[-1] <= arr[i]:
            st.pop()
        res[i] = st[-1] if st else -1
        st.append(arr[i])
    return res
arr = [1, 3, 2, 4]
print(next_greater(arr))