# Leetcode problem 205 
# Isomorphic Strings

class Solution(object):
    def isIsomorphic(self, s, t):
        d1 = {}
        d2 = {}

        for i in range(len(s)):

            if s[i] in d1:
                if d1[s[i]] != t[i]:
                    return False
            else:
                d1[s[i]] = t[i]

            if t[i] in d2:
                if d2[t[i]] != s[i]:
                    return False
            else:
                d2[t[i]] = s[i]

        return True