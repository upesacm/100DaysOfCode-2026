a=input("Enter a string: ")
b=a.lower()
x=[]
for i in b:
  if i not in "aeiou":
    x.append('.')
    x.append(i)
print("".join(x))
