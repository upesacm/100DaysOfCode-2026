def reverseString(s):
    stack = []
    
    for c in s:
        stack.append(c)
    
    result = ""
    while stack:
        result += stack.pop()
    
    return result

print(reverseString("Hello"))