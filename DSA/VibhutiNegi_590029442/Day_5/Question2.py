n = int(input("Enter size of arrays: "))

a = list(map(int, input("Enter elements of first array: ").split()))
b = list(map(int, input("Enter elements of second array: ").split()))

if sorted(a) == sorted(b):
    print("True")
else:
    print("False")