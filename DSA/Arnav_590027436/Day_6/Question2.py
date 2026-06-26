def union(arr1, arr2):
    i, j = 0, 0
    union = []
    while i < len(arr1) and j < len(arr2):
        if arr1[i] < arr2[j]:
            if not union or union[-1] != arr1[i]:
                union.append(arr1[i])
            i += 1
        elif arr1[i] > arr2[j]:
            if not union or union[-1] != arr2[j]:
                union.append(arr2[j])
            j += 1
        else:
            if not union or union[-1] != arr1[i]:
                union.append(arr1[i])
            i += 1
            j += 1
    while i < len(arr1):
        if not union or union[-1] != arr1[i]:
            union.append(arr1[i])
        i += 1
    
    while j < len(arr2):
        if not union or union[-1] != arr2[j]:
            union.append(arr2[j])
        j += 1

    return union


n = int(input("length = "))
arr1 = sorted([int(input(f"num {i+1} = ")) for i in range(n)])
n = int(input("length = "))
arr2 = sorted([int(input(f"num {i+1} = ")) for i in range(n)])

print(union(arr1, arr2))