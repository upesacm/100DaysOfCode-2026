# Reverse a String Using Stack

s = input("Enter a string: ")

stack = []

for ch in s:
    stack.append(ch)

reversed_string = ""

while stack:
    reversed_string += stack.pop()

print("Reversed string:", reversed_string)