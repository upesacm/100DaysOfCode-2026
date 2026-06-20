def union(a, b):
    i = j = 0
    ans = []

    while i < len(a) and j < len(b):

        if a[i] < b[j]:
            if not ans or ans[-1] != a[i]:
                ans.append(a[i])
            i += 1

        elif a[i] > b[j]:
            if not ans or ans[-1] != b[j]:
                ans.append(b[j])
            j += 1

        else:
            if not ans or ans[-1] != a[i]:
                ans.append(a[i])
            i += 1
            j += 1

    while i < len(a):
        if not ans or ans[-1] != a[i]:
            ans.append(a[i])
        i += 1

    while j < len(b):
        if not ans or ans[-1] != b[j]:
            ans.append(b[j])
        j += 1

    return ans


a = [1,2,3,4,5]
b = [1,2,3,6,7]

print(union(a, b))