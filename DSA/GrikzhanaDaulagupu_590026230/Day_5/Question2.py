class Solution:
    def checkEqual(self, a, b) -> bool:
        return sorted(a) == sorted(b)
