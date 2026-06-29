n = int(input("Enter number of elements: "))
a = []
print("Enter elements :")
for i in range(n):
    a.append(int(input()))
print("Reversed list:")
for i in range(n - 1, -1, -1):
    print(a[i], end=" ")