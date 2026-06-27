# problem 2
# Smallest Distinct Window 

str = input("Enter string: ").strip()
distinct_needed = len(set(str))

count = {}
left = 0
distinct_found = 0
min_len = len(str)

for right in range(len(str)):
    ch = str[right]

    if ch not in count:
        count[ch] = 0
    count[ch] += 1

    if count[ch] == 1:
        distinct_found += 1

    while distinct_found == distinct_needed:
        min_len = min(min_len, right - left + 1)

        count[str[left]] -= 1
        if count[str[left]] == 0:
            distinct_found -= 1
            
        left += 1
print("Output is:", min_len)