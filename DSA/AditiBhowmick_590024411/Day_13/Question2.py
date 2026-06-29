def count_distinct_subsequences(s):
    subsequences = {""}

    for ch in s:
        new_subsequences = set()
        for sub in subsequences:
            new_subsequences.add(sub + ch)
        subsequences.update(new_subsequences)

    return len(subsequences)

s1 = input("Enter first string: ")
s2 = input("Enter second string: ")

count1 = count_distinct_subsequences(s1)
count2 = count_distinct_subsequences(s2)

if count1 >= count2:
    print(s1)
else:
    print(s2)