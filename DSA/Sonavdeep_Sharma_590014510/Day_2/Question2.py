arr=list(map(int,input().split()))
largest=arr[0]
for num in arr:
    if num>largest:
       largest=num
print(largest)