from collections import defaultdict

def smallestDistinctWindow(s):
    total = len(set(s))
    freq = defaultdict(int)

    left = 0
    count = 0
    ans = float('inf')

    for right in range(len(s)):
        freq[s[right]] += 1

        if freq[s[right]] == 1:
            count += 1

        while count == total:
            ans = min(ans, right - left + 1)

            freq[s[left]] -= 1
            if freq[s[left]] == 0:
                count -= 1

            left += 1

    return ans


# Driver code
s = input().strip()
print(smallestDistinctWindow(s))