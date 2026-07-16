#remove duplicates

class Solution(object):
    def removeDuplicates(self, s):

        stack = []

        for char in s:
            if stack and stack[-1] == char:
                stack.pop()
                pass

            else:
                stack.append(char)
        return ''.join(stack)