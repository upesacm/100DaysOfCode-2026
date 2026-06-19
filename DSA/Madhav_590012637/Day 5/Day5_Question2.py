a = list(map(int, input("Enter first array: ").split()))
b = list(map(int, input("Enter second array: ").split()))

a.sort()
b.sort()

print(a == b)