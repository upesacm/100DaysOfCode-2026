def process(s):
    result = []

    for ch in s:
        if ch == "#":
            if result:
                result.pop()
        else:
            result.append(ch)

    return "".join(result)

s = input("Enter first string: ")
t = input("Enter second string: ")

if process(s) == process(t):
    print("Result: Both strings are equal after processing backspaces.")
else:
    print("Result: Both strings are not equal after processing backspaces.")
