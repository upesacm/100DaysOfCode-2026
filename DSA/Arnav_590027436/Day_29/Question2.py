def reverse_str(s):
    stack = []
    
    for char in s:
        stack.append(char)
        
    reversed_chars = []
    while stack:
        reversed_chars.append(stack.pop())

    return ''.join(reversed_chars)