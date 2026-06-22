s = input()

reversed_str = ""

for i in range(len(s) - 1, -1, -1):
    reversed_str += s[i]

print(reversed_str)