def union(arr1, arr2):
    i = j = 0
    result = []

    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            result.append(arr1[i])
            i += 1
        elif arr1[i] > arr2[j]:
            result.append(arr2[j])
            j += 1
        else:
            result.append(arr1[i])
            i += 1
            j += 1

    while i < len(arr1):
        result.append(arr1[i])
        i += 1

    while j < len(arr2):
        result.append(arr2[j])
        j += 1

    return result

arr1 = [1, 2, 4, 5]
arr2 = [2, 3, 5, 6]

print(union(arr1, arr2))