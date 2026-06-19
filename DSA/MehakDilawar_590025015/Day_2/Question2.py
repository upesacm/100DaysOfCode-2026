#Given an integer array, determine the largest element present in the array.
#Input:[3,7,9,2,5]. Output:9
def max_int(int_array):
    print(max(int_array))
int_array=[]
n=int(input("Enter number of elements: "))
for i in range(n):
   x=int(input("Enter element: "))
   int_array.append(x)
max_int(int_array)