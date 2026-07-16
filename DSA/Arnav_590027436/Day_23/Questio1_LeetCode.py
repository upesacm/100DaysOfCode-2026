class Solution(object):
    def findContentChildren(self, g, s):
        s.sort()
        g.sort()
        satisfied_count = 0
        child_ptr = 0
        cookie_ptr = 0

        while child_ptr < len(g) and cookie_ptr < len(s):
            if g[child_ptr] <= s[cookie_ptr]:
                satisfied_count += 1
                child_ptr += 1
            
            cookie_ptr +=1
        
        return satisfied_count