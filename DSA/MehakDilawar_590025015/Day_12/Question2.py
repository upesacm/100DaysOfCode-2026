#Find the length of the shortest substring that contains every distinct character present in the given string at least once.
#Input:str="abcda". Output:4
def shortest_substring(s):
    unique = set(s)
    ans = len(s)
    for i in range(len(s)):
        seen = set()
        for j in range(i, len(s)):
            seen.add(s[j])
            if seen == unique:
                ans = min(ans, j - i + 1)
                break
    return ans

x=input("Enter string: ")
print(shortest_substring(x))  