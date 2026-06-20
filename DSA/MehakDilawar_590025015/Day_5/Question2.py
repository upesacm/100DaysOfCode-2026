#Given two arrays, determine whether they are equal. 
#Two arrays are considered equal if they have the same size and corresponding elements are identical..
#Input: arr1=[1,2,34] arr2[4,3,2,1]. Output:True
def are_equal(arr1, arr2):
    if len(arr1) != len(arr2):
        return False

    for i in range(len(arr1)):
        if arr1[i] != arr2[i]:
            return False

    return True


arr1 = list(map(int, input("Enter elements of first array: ").split()))
arr2 = list(map(int, input("Enter elements of second array: ").split()))
print(are_equal(arr1, arr2)) 