s1 = input()
s2 = input()

dp1 = [0] * (len(s1) + 1)
dp1[0] = 1
last1 = {}

for i in range(1, len(s1) + 1):
    dp1[i] = 2 * dp1[i - 1]
    ch = s1[i - 1]

    if ch in last1:
        dp1[i] -= dp1[last1[ch] - 1]

    last1[ch] = i

dp2 = [0] * (len(s2) + 1)
dp2[0] = 1
last2 = {}

for i in range(1, len(s2) + 1):
    dp2[i] = 2 * dp2[i - 1]
    ch = s2[i - 1]

    if ch in last2:
        dp2[i] -= dp2[last2[ch] - 1]

    last2[ch] = i

if dp1[len(s1)] >= dp2[len(s2)]:
    print(s1)
else:
    print(s2)