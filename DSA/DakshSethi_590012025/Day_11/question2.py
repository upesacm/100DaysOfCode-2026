s = input()

vowels = "AEIOUYaeiouy"
ans = ""

for ch in s:
    if ch not in vowels:
        ans += "." + ch.lower()

print(ans)