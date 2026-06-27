from collections import defaultdict

def smallestDistinctWindow(str):
    distinct = len(set(str))
    freq = defaultdict(int)

    left = 0
    count = 0
    ans = float('inf')

    for right in range(len(str)):
        freq[str[right]] += 1

        if freq[str[right]] == 1:
            count += 1

        while count == distinct:
            ans = min(ans, right - left + 1)

            freq[str[left]] -= 1
            if freq[str[left]] == 0:
                count -= 1

            left += 1

    return ans


s = input().strip()
print(smallestDistinctWindow(s))