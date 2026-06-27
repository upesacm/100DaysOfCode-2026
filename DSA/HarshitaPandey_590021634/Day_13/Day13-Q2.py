import re
from collections import Counter


def mostCommonWord(self, paragraph, banned):

    
    normalized_str = re.sub(r'[^\w\s]', ' ', paragraph).lower()
    
    
    words = normalized_str.split()
    
    
    banned_set = set(banned)
    
    
    word_counts = Counter(word for word in words if word not in banned_set)
    
    
    return word_counts.most_common(1)[0][0]


