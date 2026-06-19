'''
Check Equal Arrays
Explanation
Given two arrays, determine whether they are equal. Two arrays are considered equal if they have the same size and corresponding elements are identical..
'''

arr1 = list(map(int, input("Enter the elements array 1: ").split()))
arr2 = list(map(int, input("Enter the elements array 2: ").split()))

if len(arr1) != len(arr2):
    print("False")
elif sorted(arr1) == sorted(arr2):
    print("True")
else:
    print("False")
