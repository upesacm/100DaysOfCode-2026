class Solution(object):
    def isIsomorphic(self, s, t):
        
        map_st = {}
        map_ts = {}

        for i in range(len(s)):
            c1 = s[i]
            c2 = t[i]

            if c1 in map_st:
                if map_st[c1] != c2:
                    return False
            else:
                map_st[c1] = c2

            if c2 in map_ts:
                if map_ts[c2] != c1:
                    return False
            else:
                map_ts[c2] = c1

        return True