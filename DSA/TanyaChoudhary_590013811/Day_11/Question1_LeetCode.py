class Solution:
    def isIsomorphic(self, s, t):
        s_to_t = {}
        t_to_s = {}

        for c1, c2 in zip(s, t):
            if c1 in s_to_t:
                if s_to_t[c1] != c2:
                    return False
            else:
                if c2 in t_to_s:
                    return False
                s_to_t[c1] = c2
                t_to_s[c2] = c1

        return True