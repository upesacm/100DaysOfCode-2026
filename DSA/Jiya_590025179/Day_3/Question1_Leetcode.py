class Solution(object):
    def plusOne(self, digits):
       l=map(str,digits)
       l="".join(l)
       return list(map(int,str(int(l)+1)))
        
