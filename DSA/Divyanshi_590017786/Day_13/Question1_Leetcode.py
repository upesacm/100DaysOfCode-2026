class Solution:
    def mostCommonWord(self, paragraph: str, banned: list[str]) -> str:
        banned = set(banned)
        freq = {}
        word = []

        for ch in paragraph.lower() + " ":
            if ch.isalpha():
                word.append(ch)
            elif word:
                w = "".join(word)
                if w not in banned:
                    freq[w] = freq.get(w, 0) + 1
                word = []

        return max(freq, key=freq.get)