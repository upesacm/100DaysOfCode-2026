class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        from collections import Counter
        banned = set(banned)
        for ch in "!?',;.":
            paragraph = paragraph.replace(ch, " ")
        words = paragraph.lower().split()
        cnt = Counter()
        for word in words:
            if word not in banned:
                cnt[word] += 1
        return cnt.most_common(1)[0][0]