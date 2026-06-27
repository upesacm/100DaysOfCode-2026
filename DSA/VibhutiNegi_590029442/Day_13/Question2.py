def countSubsequence(s):
    n = len(s)
    d = [0] * (n + 1)
    d[0] = 1
    last = {}
    for i in range(1, n + 1):
        d[i] = d[i - 1] * 2
        if s[i - 1] in last:
            d[i] = d[i] - d[last[s[i - 1]] - 1]
        last[s[i - 1]] = i
    return d[n]
s1 = input()
s2 = input()

if countSubsequence(s1) >= countSubsequence(s2):
    print(s1)
else:
    print(s2)