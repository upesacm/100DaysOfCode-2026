def smallest_distinct_window(s):
    if not s:
        return 0

    req_chars = len(set(s))
    char_count = {}
    min_len = len(s)
    distinct_count = 0
    left = 0

    for right, char in enumerate(s):
        if char_count.get(char, 0) == 0:
            distinct_count += 1
        char_count[char] = char_count.get(char, 0) + 1

        while distinct_count == req_chars:
            min_len = min(min_len, right - left + 1)
            char_count[s[left]] -= 1
            if char_count[s[left]] == 0:
                distinct_count -= 1
            left += 1
    
    return min_len

str = input("Enter the string: ")
print("result : ", smallest_distinct_window(str))