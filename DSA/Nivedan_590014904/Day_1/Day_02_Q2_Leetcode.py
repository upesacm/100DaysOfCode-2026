n = int(input("The number of elements in the array are: "))
arr = []
for i in range (n):
    num = int(input("Enter the elements in array: "))
    arr.append(num)
arr = sorted(arr)
for i in range (len(arr)):
    if arr[i] != i:
        print(i)
        break
else:
    print(len(arr))