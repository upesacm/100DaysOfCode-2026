class Solution(object):
    def mostCommonWord(self, paragraph, banned):
        punctuation = ['!', '?', "'", ',', ';', '.', ':', '"']
        clean_para = paragraph

        for symbol in punctuation:
            clean_para = clean_para.replace(symbol, ' ')
        
        clean_para = clean_para.lower()
        words = clean_para.split()

        banned_set = set(banned)
        word_count = {}
        max_count = 0
        most_common_word = ""

        for word in words:
            if word not in banned_set:
                if word in word_count:
                    word_count[word] += 1
                else:
                    word_count[word] = 1
            
                if word_count[word] > max_count:
                    max_count = word_count[word]
                    most_common_word = word
        
        return most_common_word