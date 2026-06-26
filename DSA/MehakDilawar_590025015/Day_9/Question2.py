#Remove all spaces from a string and print the modified string.
#Input:C od ing. Output:Coding
def del_space(s):
  x=s.replace(" ", "")
  print(x)
s=input("Enter a string: ")
del_space(s)