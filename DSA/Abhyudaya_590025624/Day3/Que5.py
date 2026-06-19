class Solution(object):
    def plusOne(self, digits):
        a=0
        n=len(digits)
        for i in range(n):
            a=10*a+digits[i]
        a=a+1
        n=len(str(a))
        ar=[0]*n
        while(a>0):
            ar[n-1]=a%10
            a=a//10
            n=n-1
        return ar
        
#Leetcode solution ends here...