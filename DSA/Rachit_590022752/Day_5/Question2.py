def are_equal(arr1, arr2):
    if len(arr1) != len(arr2):
        return False

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False
    return True

n1 = int(input("Enter the size of first array: "))
arr1 = []
print("Enter elements of first array:")
for i in range(n1):
    arr1.append(int(input()))

n2 = int(input("Enter the size of second array: "))
arr2 = []
print("Enter elements of second array:")
for i in range(n2):
    arr2.append(int(input()))

print("Arrays are equal?", are_equal(arr1, arr2))
