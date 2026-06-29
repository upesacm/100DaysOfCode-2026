class Solution:
    def mostCommonWord(self, paragraph: str, banned: List[str]) -> str:
        for ch in ",.!?;'":
            paragraph=paragraph.replace(ch, " ")

        words=paragraph.lower().split()
        maxi=0
        for i in words:
            if i in banned:
                continue
            c=words.count(i)
            if c>maxi:
                maxi=c
                word=i
        return word
        
