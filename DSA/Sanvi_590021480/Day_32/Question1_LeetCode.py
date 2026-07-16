class Solution:
    def minLength(self, s: str) -> int:
        stack=""
        for i in s:
            stack+=i
            while "AB" in stack or "CD" in stack:
                stack=stack.replace("AB","")
                stack=stack.replace("CD","")
        return len(stack)
        
