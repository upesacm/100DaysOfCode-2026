def maximum_xor(arr):
    max_xor = 0

    for i in range(len(arr)):
        for j in range(i + 1, len(arr)):
            max_xor = max(max_xor, arr[i] ^ arr[j])

    return max_xor


n = int(input())
arr = list(map(int, input().split()))

print(maximum_xor(arr))