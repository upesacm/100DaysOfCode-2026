s = input().strip()

result = ""

for ch in s:
    ch = ch.lower()

    if ch not in "aeiouy":
        result += "." + ch

print(result)
