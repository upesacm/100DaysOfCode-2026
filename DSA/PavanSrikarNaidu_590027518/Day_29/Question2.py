s = input().strip()

stack = []

# Push all characters onto the stack
for ch in s:
    stack.append(ch)

# Pop characters to form the reversed string
reversed_string = ""

while stack:
    reversed_string += stack.pop()

print(reversed_string)