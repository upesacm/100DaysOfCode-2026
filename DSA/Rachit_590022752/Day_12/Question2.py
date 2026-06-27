def smallestDistinctWindow(s: str) -> int:
    distinct_chars = set(s)
    required = len(distinct_chars)

    freq = {}
    left = 0
    count = 0
    min_len = len(s)

    for right in range(len(s)):
        freq[s[right]] = freq.get(s[right], 0) + 1
        if freq[s[right]] == 1:
            count += 1

        while count == required:
            min_len = min(min_len, right - left + 1)
            freq[s[left]] -= 1
            if freq[s[left]] == 0:
                count -= 1
            left += 1

    return min_len

user_input = input("Enter a string: ")
print("Length of smallest distinct window:", smallestDistinctWindow(user_input))
