class Solution(object):
    def isIsomorphic(self, s, t):
        
        if len(s) != len(t):
            return False
        
        return map(s.find, s) == map(t.find, t)