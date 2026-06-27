def smallestDistinctWindow(s):
    distinct = set(s)
    required = len(distinct)
    
    left = 0
    current = {}
    count = 0
    min_len = len(s)
    
    for right in range(len(s)):
        c = s[right]
        current[c] = current.get(c, 0) + 1
        if current[c] == 1:
            count += 1
        
        while count == required:
            min_len = min(min_len, right - left + 1)
            
            left_c = s[left]
            current[left_c] -= 1
            if current[left_c] == 0:
                count -= 1
            left += 1
    
    return min_len