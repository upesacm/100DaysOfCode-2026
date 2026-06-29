def subsequences(s, i, curr, st):
    if i == len(s):
        st.add(curr)
        return

    subsequences(s, i + 1, curr + s[i], st)

    subsequences(s, i + 1, curr, st)

s1 = input("Enter 1st string: ")
s2 = input("Enter 2nd string: ")

set1 = set()
set2 = set()

subsequences(s1, 0, "", set1)
subsequences(s2, 0, "", set2)

if len(set1) >= len(set2):
    print(s1)
else:
    print(s2)
