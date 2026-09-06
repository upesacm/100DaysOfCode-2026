n=int(input("Enter a number: "))
l=[]
for i in range(n):
    a=int(input("Enter element: "))
    l.append(a)
maxi=0
for i in l:
    for j in l:
        ans=i^j
        if(ans>maxi):
            maxi=ans
print(f"OUTPUT: {maxi}")            
