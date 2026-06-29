phrase = input("Enter phrase: ").replace(',', '').replace('.', '').lower().split()
banned = input("Enter banned words (seb by space): ").lower().split()

freq = {}
for i in phrase:
    if i not in banned:
        freq[i] = freq.get(i, 0) + 1

max_val = 0
max_key = ''
for i, j in freq.items():
    if j>max_val:
        max_key = i
        max_val = j

print(max_key)
