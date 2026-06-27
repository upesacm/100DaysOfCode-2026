s = input()
distinct = len(set(s))
count = {}
start = 0
min_len = len(s)
have = 0
for end in range(len(s)):
    ch = s[end]
    if ch not in count:
        count[ch] = 0
    count[ch] += 1
    if count[ch] == 1:
        have += 1
    while have == distinct:
        if end - start + 1 < min_len:
            min_len = end - start + 1
        count[s[start]] -= 1
        if count[s[start]] == 0:
            have -= 1
        start += 1
print(min_len)