class Solution(object):
    def numberOfLines(self, widths, s):
        lines = 1
        current_width = 0

        for ch in s:
            w = widths[ord(ch) - ord('a')]

            if current_width + w <= 100:
                current_width += w
            else:
                lines += 1
                current_width = w

        return [lines, current_width]
