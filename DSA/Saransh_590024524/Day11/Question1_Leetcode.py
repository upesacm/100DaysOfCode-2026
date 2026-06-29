class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        dic = {}

        for i in range(len(s)):
            cha = s[i]
            if cha not in dic:
                if t[i] in dic.values():
                    return False
                dic[cha] = t[i] 
            else: 
                if dic[cha] != t[i]:
                    return False
        return True
