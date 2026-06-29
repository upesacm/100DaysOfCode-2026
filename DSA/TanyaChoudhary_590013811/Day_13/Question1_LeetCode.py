class Solution:
    def mostCommonWord(self, paragraph, banned):
        banned_set = set(banned)
        
        cleaned = ""
        for c in paragraph:
            if c.isalpha():
                cleaned += c.lower()
            else:
                cleaned += " "
        
        words = cleaned.split()
        
        count = {}
        for word in words:
            if word not in banned_set:
                count[word] = count.get(word, 0) + 1
        
        max_count = 0
        result = ""
        for word in count:
            if count[word] > max_count:
                max_count = count[word]
                result = word
        
        return result