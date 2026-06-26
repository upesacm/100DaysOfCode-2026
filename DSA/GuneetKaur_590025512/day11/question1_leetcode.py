class Solution :
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
            return False
        st={}
        ts={}
        for c1,c2 in zip(s,t):
            if s[c1] != c2:
                return False
            else:
                st[c1]=c2
            if t[c2] != c1:
                return False
            else:
                ts[c2]=c1
        return True   
            
        
