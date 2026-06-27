s = input("Enter the string: ")

target = len(set(s))

left = 0
window = {}
min_len = float('inf')

for right in range(len(s)):
    ch = s[right]
    window[ch] = window.get(ch, 0) + 1

    while len(window) == target:
        min_len = min(min_len, right - left + 1)

        left_char = s[left]
        window[left_char] -= 1

        if window[left_char] == 0:
            del window[left_char]

        left += 1

print(min_len)