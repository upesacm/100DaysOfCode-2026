class Solution(object):
    def plusOne(self, digits):
        """
        :type digits: List[int]
        :rtype: List[int]
        """
        num=0
        n=len(digits)
        for i in range(n):
            num+=digits[i]*(10**(n-1))
            n-=1
        num+=1
        new_list=[int(x) for x in str(num)]
        return new_list