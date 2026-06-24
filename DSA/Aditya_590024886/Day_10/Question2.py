a=input("Enter a string: ")
b="".join(a.split())
if len(set(b))%2==0:
  print("CHAT WITH HER!")
else:
  print("IGNORE HIM!")
