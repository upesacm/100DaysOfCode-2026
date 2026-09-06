import math

def encrypt(s):
    # Remove spaces
    s = s.replace(" ", "")
    length = len(s)

    # Find rows and columns close to sqrt(length)
    rows = int(math.sqrt(length))
    cols = rows

    if rows * cols < length:
        cols += 1

    if rows * cols < length:
        rows += 1

    # Build the encrypted string column by column
    result = []

    for col in range(cols):
        word = ""

        for row in range(rows):
            index = row * cols + col

            if index < length:
                word += s[index]

        result.append(word)

    return " ".join(result)


s = "haveaniceday"
print(encrypt(s))