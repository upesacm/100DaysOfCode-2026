class Solution:
    def mostCommonWord(self, paragraph: str, banned: list[str]) -> str:

        banned = set(banned)
        count = {}

        word = ""

        for ch in paragraph.lower():
            if ch.isalpha():
                word += ch
            else:
                if word:
                    if word not in banned:
                        count[word] = count.get(word, 0) + 1
                    word = ""

        # Handle the last word
        if word:
            if word not in banned:
                count[word] = count.get(word, 0) + 1

        ans = ""
        maxi = 0

        for w in count:
            if count[w] > maxi:
                maxi = count[w]
                ans = w

        return ans