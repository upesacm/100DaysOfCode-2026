class Solution(object):
    def removeDuplicates(self, s):
        stack = []
        for char in s:
            if stack and char == stack[-1]:
                stack.pop()
            else:
                stack.append(char)
        
        return ''.join(stack)