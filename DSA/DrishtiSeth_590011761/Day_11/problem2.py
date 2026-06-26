s = input()

vowels = "aeiouAEIOU"
answer = ""

for ch in s:
    if ch not in vowels:
        answer += "." + ch.lower()

print(answer)
