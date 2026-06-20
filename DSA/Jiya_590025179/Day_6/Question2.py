l1=[]
l2=[]
n1=int(input("Enter size of arr1: "))
for i in range (n1):
    a=int(input("Enter element: "))
    l1.append(a)
n2=int(input("Enter size of arr2: "))  
for i in range (n2):
    a=int(input("Enter element: "))
    l2.append(a)
print(f"UNION- {set(l1).union(set(l2)) }")    
