n, m = map(int, input().split())
arr1 = list(map(int, input().split()))
arr2 = list(map(int, input().split()))

i = j = 0
ans = []

while i < n and j < m:
    if arr1[i] < arr2[j]:
        if not ans or ans[-1] != arr1[i]:
            ans.append(arr1[i])
        i += 1

    elif arr1[i] > arr2[j]:
        if not ans or ans[-1] != arr2[j]:
            ans.append(arr2[j])
        j += 1

    else:
        if not ans or ans[-1] != arr1[i]:
            ans.append(arr1[i])
        i += 1
        j += 1

while i < n:
    if not ans or ans[-1] != arr1[i]:
        ans.append(arr1[i])
    i += 1

while j < m:
    if not ans or ans[-1] != arr2[j]:
        ans.append(arr2[j])
    j += 1

print(*ans)
