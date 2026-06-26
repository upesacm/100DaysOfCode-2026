n=int(input("Enter the number of elements in the array: "))
ar=[]
lar=0
print("Enter the elements in the array: ")  
for i in range(n):
    ar.append(int(input()))
    if (ar[i]>lar):
        lar=ar[i]
print("The largest element in the array is: ", lar) 
#~abhyudaya_590025624_DAY2 done