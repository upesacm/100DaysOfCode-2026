'''Most Common Word
Explanation
Find the most frequently occurring word in a paragraph that is not present in the banned words list. Ignore punctuation and letter casing while processing the text.'''

class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        
        for ch in ",.!?;'":
            paragraph = paragraph.replace(ch, " ")

        words = paragraph.lower().split()

        max = 0

        for i in range(len(words)):
            if words[i] in banned:
                continue

            if words.count(words[i]) > max:
                max = words.count(words[i])
                word = words[i]

        return word