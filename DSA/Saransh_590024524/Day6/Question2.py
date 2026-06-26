def unionArrays(a, b):
    i, j = 0, 0
    union = []

    while i < len(a) and j < len(b):

        if a[i] < b[j]:
            if not union or union[-1] != a[i]:
                union.append(a[i])
            i += 1

        elif a[i] > b[j]:
            if not union or union[-1] != b[j]:
                union.append(b[j])
            j += 1

        else:
            if not union or union[-1] != a[i]:
                union.append(a[i])
            i += 1
            j += 1

    while i < len(a):
        if not union or union[-1] != a[i]:
            union.append(a[i])
        i += 1

    while j < len(b):
        if not union or union[-1] != b[j]:
            union.append(b[j])
        j += 1

    return union