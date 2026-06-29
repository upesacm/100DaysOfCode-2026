class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        banned = set(banned)
        count = {}
        word = ""
        for ch in paragraph.lower():
            if ch.isalpha():
                word += ch
            else:
                if word:
                    if word not in banned:
                        if word in count:
                            count[word] += 1
                        else:
                            count[word] = 1
                    word = ""
        if word:
            if word not in banned:
                if word in count:
                    count[word] += 1
                else:
                    count[word] = 1
        ans = ""
        maxCount = 0
        for w in count:
            if count[w] > maxCount:
                maxCount = count[w]
                ans = w
        return ans