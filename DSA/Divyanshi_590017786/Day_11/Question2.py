s = input().lower()

result = ""

for ch in s:
    if ch not in "aeiouy":
        result += "." + ch

print(result)
