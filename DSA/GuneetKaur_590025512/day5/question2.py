arr1=list(map(int,input("Enter the first array elements: ").split()))
arr2=list(map(int,input("Enter the second array elements: ").split()))
if sorted(arr1)==sorted(arr2):
    print("True")
else:    print("False")