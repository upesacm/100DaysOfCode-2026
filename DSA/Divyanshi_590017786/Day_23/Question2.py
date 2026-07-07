def process(s):
    stack = []
    for ch in s:
        if ch == '#':
            if stack:
                stack.pop()
        else:
            stack.append(ch)
    return "".join(stack)

s = input()
t = input()

if process(s) == process(t):
    print("true")
else:
    print("false")
