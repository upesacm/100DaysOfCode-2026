l=[]
n=int(input("Enter size: "))
for i in range (n):
    a=int(input("Enter number: "))
    l.append(a)
b=int(input("Enter step: "))
b=b%n
l=l[-b:]+l[:-b]
print(f"Rotated- {l}")
