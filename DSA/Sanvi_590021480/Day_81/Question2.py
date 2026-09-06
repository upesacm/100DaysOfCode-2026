arr=list(map(int,input("Enter elements: ").split()))
for i in arr:
    if arr.count(i)==1:
        print(i)
        break
