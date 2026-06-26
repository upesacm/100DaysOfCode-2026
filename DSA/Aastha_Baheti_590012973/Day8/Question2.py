s = input().strip()

reversed_string = ""

for i in range(len(s) - 1, -1, -1):
    reversed_string += s[i]

print(reversed_string)