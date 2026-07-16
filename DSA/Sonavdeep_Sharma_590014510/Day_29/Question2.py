s = input()

stack = []

for ch in s:
    stack.append(ch)

while stack:
    print(stack.pop(), end="")