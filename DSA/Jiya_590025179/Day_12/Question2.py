string=input("Enter a string: ")
ans=len(string)
for i in range(len(string)):
  for j in range(i,len(string)):
    if len(set(string[i:j+1]))==len(set(string)):
      ans=min(ans,j-i+1)
print(f"Output: {ans}")
