class Solution:
    def plusOne(self, digits: List[int]) -> List[int]:
        sum=int("".join(map(str,digits)))
        sum=sum+1
        n=str(abs(sum))
        a=[int(x) for x in n]
        
        return a
        
