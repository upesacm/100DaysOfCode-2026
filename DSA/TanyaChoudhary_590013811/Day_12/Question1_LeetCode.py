class Solution:
    def numberOfLines(self, widths, s):
        lines = 1
        current_width = 0

        for c in s:
            w = widths[ord(c) - ord('a')]

            if current_width + w > 100:
                lines += 1
                current_width = w
            else:
                current_width += w

        return [lines, current_width]