def removeSpaces(s):
    result = ""

    for ch in s:
        if ch != " ":
            result += ch

    return result


s = "C od ing"
print(removeSpaces(s))