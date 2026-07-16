def next_greater(arr):
    stack = []
    result = [-1 for _ in range(len(arr))]

    for i in range(len(arr)):
        while stack and arr[i] > arr[stack[-1]]:
            idx = stack.pop()
            result[idx] = arr[i]
        stack.append(i)

    return result