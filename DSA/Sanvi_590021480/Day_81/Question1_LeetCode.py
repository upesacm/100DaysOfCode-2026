class Solution:
    def hammingDistance(self, x: int, y: int) -> int:
        a=bin(x)[2:]
        b=bin(y)[2:]
        len1=len(a)
        len2=len(b)
        if len1>len2:
            b="0"*(len1-len2)+b
        if len2>len1:
            a="0"*(len2-len1)+a

        count=0
        for i in range(len(a)):
            if a[i]==b[i]:
                continue
            else:
                count+=1
        return count
        
