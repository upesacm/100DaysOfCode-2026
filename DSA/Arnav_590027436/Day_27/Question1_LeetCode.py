class Solution(object):
    def compress(self, chars):
        write = 0
        read = 0

        while read < len(chars):
            run_end = read
            char = chars[read]
            while run_end < len(chars) and chars[run_end] == char:
                run_end += 1
            count = run_end - read
            chars[write] = char
            write += 1
            if count > 1:
                for digit in str(count):
                    chars[write] = digit
                    write += 1
            read = run_end

        return write