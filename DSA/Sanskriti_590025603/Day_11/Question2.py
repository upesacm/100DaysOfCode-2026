s = input()

result = ""

vowels = "aeiouAEIOU"

for ch in s:
    if ch not in vowels:
        result += "." + ch.lower()

print(result)