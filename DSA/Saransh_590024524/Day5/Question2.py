a = list(map(int, input().split()))
b = list(map(int, input().split()))

freq = {}

for num in a:
    freq[num] = freq.get(num, 0) + 1

for num in b:
    if num not in freq:
        print("false")
        exit()
    freq[num] -= 1
    if freq[num] < 0:
        print("false")
        exit()

for value in freq.values():
    if value != 0:
        print("false")
        exit()

print("true")