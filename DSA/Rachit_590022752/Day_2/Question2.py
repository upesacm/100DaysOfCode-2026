arr = []
n = int(input("Enter the number of elements: "))
for i in range(n):
    num = int(input("Enter a number: "))
    arr.append(num)

maximum_number = max(arr)
print("Largest Number: ", maximum_number)
