import re
from collections import Counter

class Solution:
    def mostCommonWord(self, paragraph, banned):
        banned = set(word.lower() for word in banned)

        words = re.findall(r"[a-zA-Z]+", paragraph.lower())

        count = Counter(word for word in words if word not in banned)

        return count.most_common(1)[0][0]


# Example
paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]

obj = Solution()
print(obj.mostCommonWord(paragraph, banned))
