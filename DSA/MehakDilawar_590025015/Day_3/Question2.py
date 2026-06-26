#Given an sorted integer array and a target value, count the number of occurrences of the target in the array and return the result.
#Input:[1,1,2,2,2,2] target:2. Output:4
def target_occurence(integer, target):
   count=0
   for i in range(len(integer)):
    if integer[i]==target:
        count+=1
   print(count)

integer=[]
n=int(input("Enter no. of elements: "))
for i in range(n):
    x=int(input("Enter element: "))
    integer.append(x)
    integer.sort()
target=int(input("Enter target value: "))
target_occurence(integer, target)

