class Solution(object):
    def numberOfLines(self, widths, s):
        
        lines, current_width = 1, 0
        
        for char in s:
            char_width = widths[ord(char) - ord('a')]

            if current_width + char_width > 100:
                lines += 1
                current_width = char_width
            else:
                current_width += char_width
            
        return [lines, current_width]