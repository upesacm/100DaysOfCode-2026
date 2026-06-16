l = []
n = int(input("Enter size: "))

for i in range(n):
    a = int(input("Enter number: "))
    l.append(a)

total = 0
for num in l:
    total += num

print("Sum:", total)