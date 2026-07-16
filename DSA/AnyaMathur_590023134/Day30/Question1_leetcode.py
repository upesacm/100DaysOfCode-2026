# Leetcode Problem 1047 
# Remove All Adjacent Duplicates In String  

class Solution(object):
    def removeDuplicates(self, s):
        stack = []

        for ch in s:
            if stack and stack[-1] == ch:
                stack.pop()
            else:
                stack.append(ch)

        return "".join(stack)