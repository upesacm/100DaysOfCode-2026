#Reverse the given string using a stack and print the reversed string.
#Input:s = hello. Output:olleh
s = input("Enter a string: ")
stack = []
for ch in s:
    stack.append(ch)
reversed_string = ""
while stack:
    reversed_string += stack.pop()
print(reversed_string)