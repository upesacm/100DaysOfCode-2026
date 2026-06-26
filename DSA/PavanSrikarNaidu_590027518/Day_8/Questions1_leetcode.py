class Solution:
    def isPalindrome(self, s: str) -> bool:
        cleaned = ""

        for ch in s:
            if ch.isalnum():
                cleaned += ch.lower()

        return cleaned == cleaned[::-1]


obj = Solution()

print(obj.isPalindrome("A man, a plan, a canal: Panama"))
print(obj.isPalindrome("race a car"))
print(obj.isPalindrome(" "))