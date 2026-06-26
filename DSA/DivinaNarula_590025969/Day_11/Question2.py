# String Processing Task

s = input().strip()

vowels = "AEIOUYaeiouy"

result = ""

for ch in s:
    if ch not in vowels:
        result += "." + ch.lower()

print(result)