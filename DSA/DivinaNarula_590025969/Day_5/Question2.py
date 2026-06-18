def are_equal(arr1, arr2):
    if len(arr1) != len(arr2):
        return False

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False

    return True


arr1 = list(map(int, input("Enter elements of first array: ").split()))
arr2 = list(map(int, input("Enter elements of second array: ").split()))

if are_equal(arr1, arr2):
    print("True")
else:
    print("False")