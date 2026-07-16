class Solution:
    def removeDuplicates(self, s: str) -> str:
        stack = []

        for ch in s:
            if stack and stack[-1] == ch:
                stack.pop()
            else:
                stack.append(ch)

        return "".join(stack)


# Example
obj = Solution()
print(obj.removeDuplicates("abbaca"))   # ca
print(obj.removeDuplicates("azxxzy"))   # ay
