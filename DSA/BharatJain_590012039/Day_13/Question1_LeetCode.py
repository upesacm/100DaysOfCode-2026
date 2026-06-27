class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        banned = set(banned)
        word = ""
        count = {}

        for ch in paragraph.lower() + " ":
            if ch.isalpha():
                word += ch
            elif word:
                if word not in banned:
                    count[word] = count.get(word, 0) + 1
                word = ""

        return max(count, key=count.get)


paragraph = "Bob hit a ball, the hit BALL flew far after it was hit."
banned = ["hit"]

sol = Solution()
print(sol.mostCommonWord(paragraph, banned))