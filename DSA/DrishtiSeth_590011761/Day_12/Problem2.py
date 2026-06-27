class Solution:
    def findSubString(self, s):
        total = len(set(s))
        freq = {}
        left = 0
        count = 0
        ans = len(s)

        for right in range(len(s)):
            ch = s[right]

            freq[ch] = freq.get(ch, 0) + 1

            if freq[ch] == 1:
                count += 1

            while count == total:
                ans = min(ans, right - left + 1)

                freq[s[left]] -= 1

                if freq[s[left]] == 0:
                    count -= 1

                left += 1

        return ans


# Example
s = "abcda"

obj = Solution()
print(obj.findSubString(s))
