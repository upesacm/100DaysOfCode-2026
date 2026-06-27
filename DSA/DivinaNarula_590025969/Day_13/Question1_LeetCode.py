# Most Common Word

from collections import defaultdict

class Solution:
    def mostCommonWord(self, paragraph, banned):
        banned = set(banned)
        freq = defaultdict(int)

        word = ""
        ans = ""
        max_freq = 0

        for ch in paragraph.lower() + " ":
            if ch.isalpha():
                word += ch
            elif word:
                if word not in banned:
                    freq[word] += 1
                    if freq[word] > max_freq:
                        max_freq = freq[word]
                        ans = word
                word = ""

        return ans