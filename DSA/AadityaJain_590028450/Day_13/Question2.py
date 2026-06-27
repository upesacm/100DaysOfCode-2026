'''Better String
Explanation
Determine which of the two given strings has more distinct subsequences, returning the first string if both have the same number.'''

strings = []
counts = []

for j in range(2):
    s = input(f"Enter string {j + 1}: ")
    strings.append(s)

    n = len(s)
    dp = [0] * (n + 1)
    dp[0] = 1
    last = {}

    for i in range(1, n + 1):
        dp[i] = 2 * dp[i - 1]

        if s[i - 1] in last:
            dp[i] = dp[i] - dp[last[s[i - 1]] - 1]

        last[s[i - 1]] = i

    counts.append(dp[n])

if counts[0] >= counts[1]:
    print(strings[0])
else:
    print(strings[1])