def EqualArrays(a, b):
    if len(a) != len(b):
        return False
    freq = {}
    for num in a:
        freq[num] = freq.get(num, 0) + 1
    for num in b:
        if num not in freq:
            return False
        freq[num] -= 1
        if freq[num] == 0:
            del freq[num]

    return len(freq) == 0

a = [1, 2, 5, 4, 0]
b = [2, 4, 5, 0, 1]

print(EqualArrays(a, b))