from typing import List
class Solution:
    def compress(self, chars: List[str]) -> int:
        write = 0
        i = 0
        n = len(chars)
        while i < n:
            ch = chars[i]
            count = 0
            while i < n and chars[i] == ch:
                i += 1
                count += 1
            chars[write] = ch
            write += 1
            if count > 1:
                for digit in str(count):
                    chars[write] = digit
                    write += 1
        return write