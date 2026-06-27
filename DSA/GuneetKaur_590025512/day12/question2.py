
class Solution:
    def SubString(self, s):
        distinct = len(set(s))

        left = 0
        freq = {}
        formed = 0
        ans = float('inf')

        for right in range(len(s)):
            ch = s[right]

            freq[ch] = freq.get(ch, 0) + 1

            if freq[ch] == 1:
                formed += 1

            while formed == distinct:
                ans = min(ans, right - left + 1)

                freq[s[left]] -= 1

                if freq[s[left]] == 0:
                    formed -= 1

                left += 1

        return ans