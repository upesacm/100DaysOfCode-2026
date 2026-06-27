class Solution:
    def mostCommonWord(self, paragraph, banned):
        # Convert paragraph to lowercase
        paragraph = paragraph.lower()

        # Remove punctuation
        for ch in "!?',;.":
            paragraph = paragraph.replace(ch, " ")

        # Split into words
        words = paragraph.split()

        # Convert banned list to a set
        banned_set = set(banned)

        # Count word frequencies
        freq = {}

        for word in words:
            if word not in banned_set:
                freq[word] = freq.get(word, 0) + 1

        # Return the most frequent word
        return max(freq, key=freq.get)



paragraph = input("Enter the paragraph: ")

# Enter banned words separated by spaces
banned = input("Enter banned words (space-separated): ").split()

solution = Solution()
answer = solution.mostCommonWord(paragraph, banned)

print("Most common non-banned word:", answer)