def smallest_distinct_window(s):
    distinct = len(set(s))
    n = len(s)

    freq = {}
    start = 0
    min_len = n

    count = 0

    for end in range(n):
        ch = s[end]
        freq[ch] = freq.get(ch, 0) + 1

        if freq[ch] == 1:
            count += 1

        while count == distinct:
            min_len = min(min_len, end - start + 1)

            freq[s[start]] -= 1
            if freq[s[start]] == 0:
                count -= 1

            start += 1

    return min_len


# Input
s = input("Enter the string: ")

# Output
print("Length of smallest distinct window:", smallest_distinct_window(s))