def process_string(s):
    vowels = "aeiouAEIOU"
    result = ""

    for ch in s:
        if ch not in vowels:
            result += "." + ch.lower()

    return result


# Input
s = input()

# Output
print(process_string(s))