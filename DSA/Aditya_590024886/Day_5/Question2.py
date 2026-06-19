x=list(map(int,input("Enter elements of array 1: ").split()))
y=list(map(int,input("Enter elements of array 2: ").split()))
if sorted(x)==sorted(y):
  print("True")
else:
  print("False")
