class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        """
        :type paragraph: str
        :type banned: List[str]
        :rtype: str
        """
        paragraph = paragraph.lower()
        for ch in "!?',;.":
            paragraph = paragraph.replace(ch, " ")
        words = paragraph.split()
        banned = set(banned)
        d = {}
        for word in words:
            if word not in banned:
                if word in d:
                    d[word] += 1
                else:
                    d[word] = 1
        ans = ""
        max_count = 0
        for word in d:
            if d[word] > max_count:
                max_count = d[word]
                ans = word
        return ans