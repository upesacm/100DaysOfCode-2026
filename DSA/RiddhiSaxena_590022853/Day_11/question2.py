s = input()

vowels = "aeiouAEIOU"
result = ""

for ch in s:
    if ch not in vowels:
        result += "." + ch.lower()

print(result)