s = input("Enter a string: ")

distinct = len(set(s))
n = len(s)

min_len = n + 1

for i in range(n):
    seen = set()
    for j in range(i, n):
        seen.add(s[j])
        if len(seen) == distinct:
            min_len = min(min_len, j - i + 1)
            break

print("Length of shortest substring:", min_len)