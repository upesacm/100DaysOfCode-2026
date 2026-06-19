def are_equal(arr1, arr2):
    if len(arr1) != len(arr2):
        return False

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False

    return True


arr1 = [1, 2, 34]
arr2 = [4, 3, 2, 1]

print(are_equal(arr1, arr2))
