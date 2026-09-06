n=int(input("Enter a number: "))
b=format(n,'b')
l=list(map(int, str(b)))
a=l.count(1)
print(f"OUTPUT: {a}")
  
