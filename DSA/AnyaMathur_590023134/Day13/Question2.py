# problem 2
# Better String

def count(s):
    length = len(s)
    total = [0] * (length + 1)
    total[0] = 1

    previous = {}

    for i in range(1, length + 1):
        total[i] = 2 * total[i - 1]

        if s[i - 1] in previous:
            total[i] -= total[previous[s[i - 1]] - 1]

        previous[s[i - 1]] = i

    return total[length]


s1 = input("Enter String 1: ")
s2 = input("Enter String 2: ")

count1 = count(s1)
count2 = count(s2)

if count1 >= count2:
    print("Better String is:", s1)
else:
    print("Better String is:", s2)