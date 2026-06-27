class Solution:
    def smallestDistinctWindow(self, s: str) -> int:
        if not s:
            return 0
        
        distinct_chars = len(set(s))
        left = 0
        min_length = float('inf')
        char_count = {}
        
        for right in range(len(s)):
            char = s[right]
            char_count[char] = char_count.get(char, 0) + 1
            
            while len(char_count) == distinct_chars:
                min_length = min(min_length, right - left + 1)
                
                left_char = s[left]
                char_count[left_char] -= 1
                if char_count[left_char] == 0:
                    del char_count[left_char]
                left += 1
        
        return min_length if min_length != float('inf') else 0
