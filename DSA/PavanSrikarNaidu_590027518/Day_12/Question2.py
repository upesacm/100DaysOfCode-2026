def smallestDistinctWindow(s):
    n = len(s)

    # Count total distinct characters
    distinct = len(set(s))

    freq = {}
    left = 0
    count = 0
    ans = float('inf')

    for right in range(n):

        ch = s[right]

        freq[ch] = freq.get(ch, 0) + 1

        if freq[ch] == 1:
            count += 1

        # Window contains all distinct characters
        while count == distinct:

            ans = min(ans, right - left + 1)

            freq[s[left]] -= 1

            if freq[s[left]] == 0:
                count -= 1

            left += 1

    return ans