class Solution(object):
    def minLength(self, s):
        stack = []

        for char in s:
            if char == "B":
                if stack and stack[-1] == "A":
                    stack.pop()
                else:
                    stack.append(char)
            elif stack and char == "D":
                if stack[-1] == "C":
                    stack.pop()
                else:
                    stack.append(char)
            else:
                stack.append(char)
            
        return len(stack)