def next_greater_element(arr):
    n = len(arr)
    result = [-1] * n
    stack = []

    for i in range(n):
        while stack and arr[i] > arr[stack[-1]]:
            idx = stack.pop()
            result[idx] = arr[i]

        stack.append(i)

    return result


# Input
arr = [1, 3, 2, 4]

# Output
print(next_greater_element(arr))