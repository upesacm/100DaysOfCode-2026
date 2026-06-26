s = input()

ans = ""

for ch in s:
    ch = ch.lower()

    if ch not in "aeiou":
        ans += "."
        ans += ch

print(ans)