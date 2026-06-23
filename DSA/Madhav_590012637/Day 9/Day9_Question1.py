def lengthOfLastWord(s):
    i = len(s) - 1

    # Skip trailing spaces
    while i >= 0 and s[i] == ' ':
        i -= 1

    length = 0

    # Count characters of the last word
    while i >= 0 and s[i] != ' ':
        length += 1
        i -= 1

    return length


# Example
s = "Hello World"
print(lengthOfLastWord(s))