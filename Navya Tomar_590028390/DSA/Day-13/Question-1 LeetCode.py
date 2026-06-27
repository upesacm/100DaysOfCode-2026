class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        d = {}
        word = ""

        for ch in paragraph.lower() + " ":
            if ch.isalpha():
                word += ch
            else:
                if word and word not in banned:
                    d[word] = d.get(word, 0) + 1
                word = ""

        return max(d, key=d.get)
