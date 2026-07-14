def removeDuplicates(s: str) -> str:
    stack = []

    for ch in s:
        if stack and stack[-1] == ch:
            stack.pop()
        else:
            stack.append(ch)

    return "".join(stack)


# Example usage
s = "abbaca"
print(removeDuplicates(s))  # ca