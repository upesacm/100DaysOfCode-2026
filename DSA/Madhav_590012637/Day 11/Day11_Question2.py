def process_string(s):
    vowels = "AEIOUYaeiouy"
    result = ""

    for ch in s:
        if ch not in vowels:
            result += "." + ch.lower()

    return result


# Example usage
s = input().strip()
print(process_string(s))