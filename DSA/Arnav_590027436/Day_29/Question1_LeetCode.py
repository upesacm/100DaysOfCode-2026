class Solution(object):
    def isValid(self, s):
        mapping = {")": "(", "}": "{", "]": "["}
        stack = []
        for i in s:
            if i in mapping:
                top_element = stack.pop() if stack else '#'
                if top_element != mapping[i]:
                    return False
            else:
                stack.append(i)
            
        return not stack