class Solution:
    def numberOfLines(self, widths, s):
        lines = 1
        cur = 0

        for ch in s:
            w = widths[ord(ch) - ord('a')]

            if cur + w > 100:
                lines += 1
                cur = w
            else:
                cur += w

        return [lines, cur]