s = input()

stack = []

for ch in s:
    stack.append(ch)

reversed_string = ""

while stack:
    reversed_string += stack.pop()

print(reversed_string)