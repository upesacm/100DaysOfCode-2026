class Solution:
    def mostCommonWord(self, para: str, ban: List[str]) -> str:
        for ch in ",.!?;'":
            para=para.replace(ch," ")
        maxi=0    
        a=para.lower().split()
        for i in a:
            if i in ban:
                continue
            c=a.count(i)
            if c>maxi:
                maxi=c
                b=i
        return b
