class Solution:
    def plusOne(self, digits):
        l = len(digits)
        num = 0
        for i in digits:
            l -= 1
            num += i*(10 ** l)

        num = num+1

        dig = [int(d) for d in str(num)] 
        return dig   