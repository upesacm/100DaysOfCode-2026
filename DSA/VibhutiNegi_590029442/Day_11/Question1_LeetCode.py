class Solution(object):
    def isIsomorphic(self, s, t):
        map1 = {}
        map2 = {}
        for a, b in zip(s, t):
            if (a in map1 and map1[a] != b) or (b in map2 and map2[b] != a):
                return False
            map1[a] = b
            map2[b] = a
        return True