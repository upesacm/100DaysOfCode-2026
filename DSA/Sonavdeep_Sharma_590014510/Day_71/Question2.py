s = input().replace(" ", "")

n = len(s)

rows = int(n ** 0.5)
cols = rows

if rows * cols < n:
    cols += 1

if rows * cols < n:
    rows += 1

for i in range(cols):
    for j in range(i, n, cols):
        print(s[j], end="")
    print(" ", end="")