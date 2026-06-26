arr1 = [10, 2, 5, 8, 0]
arr2 = [0, 5, 10, 8, 2]

if len(arr1) != len(arr2):
    print("Arrays are not equal")
else:
    arr1.sort()
    arr2.sort()

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            print("Arrays are not equal")
            break
    else:
        print("Arrays are equal")