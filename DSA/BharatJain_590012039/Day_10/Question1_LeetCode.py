class Solution(object):
    def strStr(self, haystack, needle):
        if needle == "":
            return 0

        for i in range(len(haystack) - len(needle) + 1):
            if haystack[i:i + len(needle)] == needle:
                return i

        return -1


haystack = "sadbutsad"
needle = "sad"

sol = Solution()
print(sol.strStr(haystack, needle))