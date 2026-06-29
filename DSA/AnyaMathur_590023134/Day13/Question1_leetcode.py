# leetcode problem 819
# Most Common Word

class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        banned = set(banned)
        d = {}
        w = ""
        for c in paragraph.lower() + " ":
            if c.isalpha():
                w += c
            else:
                if w:
                    if w not in banned:
                        d[w] = d.get(w, 0) + 1
                    w = ""
        ans = ""
        highest = 0

        for x in d:
            if d[x] > highest:
                highest = d[x]
                ans = x
        return ans