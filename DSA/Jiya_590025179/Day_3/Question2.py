l=[]
n=int(input("Enter size: "))
for i in range (n):
    a=int(input("Enter number: "))
    l.append(a)
b=int(input("Enter target value:")) 
print(f"Count: {l.count(b)}")
