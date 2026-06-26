arr1 = list(map(int, input("Enter elements of first array: ").split()))
arr2 = list(map(int, input("Enter elements of second array: ").split()))

if len(arr1) != len(arr2):
    print("Arrays are not equal")
else:
    equal = True

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            equal = False
            break

    if equal:
        print("Arrays are equal")
    else:
        print("Arrays are not equal")