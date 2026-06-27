def shortestSubstringLength(s):
    distinct_count = len(set(s))

    left = 0
    min_length = len(s)
    freq = {}

    for right in range(len(s)):
        freq[s[right]] = freq.get(s[right], 0) + 1

        while len(freq) == distinct_count:
            min_length = min(min_length, right - left + 1)

            freq[s[left]] -= 1
            if freq[s[left]] == 0:
                del freq[s[left]]

            left += 1

    return min_length


s = "abcda"
print(shortestSubstringLength(s))