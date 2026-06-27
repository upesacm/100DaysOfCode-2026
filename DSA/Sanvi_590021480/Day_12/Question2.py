a=input("Enter a string: ")
x=len(set(a))
ans=len(a)
for i in range(len(a)):
  for j in range(i,len(a)):
    if len(set(a[i:j+1]))==x:
      ans=min(ans,j-i+1)
print(ans)
