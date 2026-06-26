s=input("Enter a string: ")
s=s.lower()
ans=[]
for i in s:
  if i not in "aeiou":
    ans.append('.')
    ans.append(i)
print("".join(ans))
