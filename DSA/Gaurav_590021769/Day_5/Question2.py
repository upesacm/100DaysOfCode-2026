def are_equal(arr1, arr2):
    if len(arr1) != len(arr2):
        return False

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False

    return True


arr1 = [1, 2, 3, 4]
arr2 = [1, 2, 3, 4]

print(are_equal(arr1, arr2))