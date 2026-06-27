def betterString(s1, s2):
    def countSubsequences(s):
        distinct = set(s)
        n = len(distinct)
        return 2 ** n - 1
    
    count1 = countSubsequences(s1)
    count2 = countSubsequences(s2)
    
    if count1 >= count2:
        return s1
    else:
        return s2