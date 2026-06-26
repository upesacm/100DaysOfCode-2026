def smallestDistinctWindow(s):
    n = len(s)

    # Count distinct characters in the whole string
    distinct = len(set(s))

    freq = {}
    start = 0
    count = 0
    min_len = n

    for end in range(n):
        freq[s[end]] = freq.get(s[end], 0) + 1

        if freq[s[end]] == 1:
            count += 1

        # record window if all distinct chars are present
        while count == distinct:
            min_len = min(min_len, end - start + 1)

            freq[s[start]] -= 1
            if freq[s[start]] == 0:
                count -= 1

            start += 1

    return min_len


# e.g
s = "abcda"
print(smallestDistinctWindow(s))
