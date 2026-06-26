s = input("Enter a string: ")

vowels = "aeiouAEIOU"
result = ""

for ch in s:
    if ch not in vowels:
        result += "." + ch.lower()

print(result)