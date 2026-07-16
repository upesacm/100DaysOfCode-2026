class Solution:
    def isValid(self, s: str) -> bool:
        stack = []
        opened = ["(", "{", "["]
        closed = [")", "}", "]"]
        closedToOpen = {")" : "(",  "}" : "{","]" : "["}

        for i in s:
            if i in opened:
                stack.append(i)
            else:
                closed = i
                if stack and (stack[-1] == closedToOpen[closed]):
                    stack.pop()
                    continue
                else:
                    return False
        
        return len(stack) == 0