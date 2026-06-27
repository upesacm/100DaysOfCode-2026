class Solution:
    def numberOfLines(self, widths: List[int], s: str) -> List[int]:
        lines = 1
        current_width = 0
        for i in range(len(s)):
          width = widths[ord(s[i]) - ord('a')]
          if current_width + width <= 100:
            current_width += width
          else :
            lines += 1
            current_width = width