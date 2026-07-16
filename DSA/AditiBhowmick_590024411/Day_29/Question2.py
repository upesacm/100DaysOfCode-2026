s = input("Enter a string: ")
stack = []

# Push characters onto the stack
for ch in s:
    stack.append(ch)

# Pop characters to get the reversed string
reversed_string = ""

while stack:
    reversed_string += stack.pop()

print("Reversed string:", reversed_string)