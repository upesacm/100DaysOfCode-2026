class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        a=set(zip(s,t))
        return len(a)==len(set(s))==len(set(t))

        
