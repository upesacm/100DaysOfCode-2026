def minLength(s: str) -> int:
    stack = []

    for ch in s:
        if stack and ((stack[-1] == 'A' and ch == 'B') or
                      (stack[-1] == 'C' and ch == 'D')):
            stack.pop()
        else:
            stack.append(ch)

    return len(stack)


# Example usage
print(minLength("ABFCACDB"))  # Output: 2
print(minLength("ACBBD"))     # Output: 5