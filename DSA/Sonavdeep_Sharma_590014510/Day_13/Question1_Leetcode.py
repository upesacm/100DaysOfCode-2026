from typing import List
class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        paragraph = paragraph.lower()
     for ch in "!?',;.":
        paragraph = paragraph.replace(ch, " ")
        words = paragraph.split()
        banned = set(banned)
        freq = {}
        for word in words:
            if word not in banned:
                freq[word] = freq.get(word, 0) + 1
        return max(freq, key=freq.get)