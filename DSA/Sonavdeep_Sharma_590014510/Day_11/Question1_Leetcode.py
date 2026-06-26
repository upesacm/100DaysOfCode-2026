class Solution:
    def isIsomorphic(self, s: str, t: str) -> bool:
        if len(s) != len(t):
         return False

        s_to_t = {}
        t_to_s = {}

        for i in range(len(s)):
            ch_s = s[i]
            ch_t = t[i]

            if ch_s in s_to_t:
                if s_to_t[ch_s] != ch_t:
                    return False
            else:
                s_to_t[ch_s] = ch_t

            if ch_t in t_to_s:
                if t_to_s[ch_t] != ch_s:
                    return False
            else:
                t_to_s[ch_t] = ch_s

        return True