class Solution:
    def numberOfLines(self, widths, s):
        lines = 1
        width = 0
        for ch in s:
            w = widths[ord(ch) - ord('a')]
            if width + w <= 100:
                width += w
            else:
                lines += 1
                width = w
        return [lines, width]