class Solution:
    def numberOfLines(self, widths, s):
        lines = 1
        curr_width = 0

        for ch in s:
            w = widths[ord(ch) - ord('a')]

            if curr_width + w <= 100:
                curr_width += w
            else:
                lines += 1
                curr_width = w

        return [lines, curr_width]