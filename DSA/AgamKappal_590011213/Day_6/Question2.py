def union_arrays(a, b):
    i = 0
    j = 0
    result = []

    while i < len(a) and j < len(b):
        if a[i] < b[j]:
            if not result or result[-1] != a[i]:
                result.append(a[i])
            i += 1

        elif a[i] > b[j]:
            if not result or result[-1] != b[j]:
                result.append(b[j])
            j += 1

        else:
            if not result or result[-1] != a[i]:
                result.append(a[i])
            i += 1
            j += 1

    while i < len(a):
        if not result or result[-1] != a[i]:
            result.append(a[i])
        i += 1

    while j < len(b):
        if not result or result[-1] != b[j]:
            result.append(b[j])
        j += 1

    return result


a = [1, 2, 3, 4, 5]
b = [1, 2, 3, 6, 7]

print(union_arrays(a, b))
