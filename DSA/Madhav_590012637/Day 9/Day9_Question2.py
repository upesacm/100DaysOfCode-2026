def removeSpaces(s):
    result = ""

    for ch in s:
        if ch != ' ':
            result += ch

    return result


# Example
s = "C od ing"
print(removeSpaces(s))