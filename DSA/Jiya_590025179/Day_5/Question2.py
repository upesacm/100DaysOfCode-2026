l1=[]
l2=[]
n1=int(input("Enter size of arr1: "))
for i in range (n1):
    a=int(input("Enter element: "))
    l1.append(a)
n2=int(input("Enter size of arr2: "))  
if(n1!=n2):
    print("False")
    exit()
for i in range (n2):
    a=int(input("Enter element: "))
    l2.append(a)    
for i in l1:
    if i not in l2:
        print("False")
        exit()
print("True")
