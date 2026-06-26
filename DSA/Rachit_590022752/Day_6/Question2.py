arr1 = []
n = int(input("Enter number of elements: "))
for i in range(n):
    arr1.append(int(input()))
arr2 = []
m = int(input("Enter number of elements: "))
for i in range(m):
    arr2.append(int(input()))
Union = list(set(arr1 + arr2))
print(Union)
