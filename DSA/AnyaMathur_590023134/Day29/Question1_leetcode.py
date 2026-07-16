# Leetcode Problem 20
# Valid Parentheses 

class Solution(object):
    def isValid(self, s):
        stack = []

        for ch in s:
            if ch == '(' or ch == '[' or ch == '{':
                stack.append(ch)
            else:
                if len(stack) == 0:
                    return False
                top = stack.pop()

                if ch == ')' and top != '(':
                    return False
                if ch == ']' and top != '[':
                    return False
                if ch == '}' and top != '{':
                    return False

        if len(stack) == 0:
            return True
        return False