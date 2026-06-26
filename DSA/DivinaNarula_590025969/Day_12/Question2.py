# Smallest Distinct Window

def smallest_distinct_window(s):
    n = len(s)

    distinct_count = len(set(s))

    freq = {}
    start = 0
    min_len = n
    count = 0

    for end in range(n):
        freq[s[end]] = freq.get(s[end], 0) + 1

        if freq[s[end]] == 1:
            count += 1

        while count == distinct_count:
            min_len = min(min_len, end - start + 1)

            freq[s[start]] -= 1
            if freq[s[start]] == 0:
                count -= 1

            start += 1

    return min_len


s = input().strip()

print(smallest_distinct_window(s))