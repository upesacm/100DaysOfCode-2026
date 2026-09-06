# Grid Encryption

import math

def grid_encryption(text):
    text = text.replace(" ", "")
    length = len(text)

    rows = int(math.sqrt(length))
    cols = math.ceil(math.sqrt(length))

    if rows * cols < length:
        rows += 1

    result = []

    for col in range(cols):
        word = ""

        for row in range(rows):
            index = row * cols + col

            if index < length:
                word += text[index]

        result.append(word)

    return " ".join(result)


text = input("Enter text: ")
encrypted_text = grid_encryption(text)

print(encrypted_text)