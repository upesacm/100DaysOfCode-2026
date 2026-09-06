class Solution:
    def findJudge(self, n: int, trust: List[List[int]]) -> int:
        for i in range(1,n+1):
            trusts=False
            trustby=0
            for j in trust:
                if j[0]==i:
                    trusts=True
                if j[1]==i:
                    trustby+=1
            if not trusts and trustby==n-1:
                return i
        return -1

        
