import re
from collections import Counter
class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """


        words = re.findall(r'[a-zA-Z]+', paragraph.lower())
        banned = set(banned)

        count = Counter(word for word in words if word not in banned)

        return count.most_common(1)[0][0]