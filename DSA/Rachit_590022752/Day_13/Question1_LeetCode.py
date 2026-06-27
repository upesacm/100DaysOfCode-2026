class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        paragraph = paragraph.lower()

        for ch in "!?',;.":
            paragraph = paragraph.replace(ch, " ")

        words = paragraph.split()
        count = {}

        for word in words:
            if word not in banned:
                if word in count:
                    count[word] += 1
                else:
                    count[word] = 1

        max_word = ""
        max_count = 0

        for word in count:
            if count[word] > max_count:
                max_count = count[word]
                max_word = word
        return max_word
