class solution:
    def number(self,widths,s):
        lines=1
        currentwidth=0
        for ch in s:
            w=widths[ord(ch)-ord('a')]
            if currentwidth+w <=100:
                currentwidth+=w
            else:
                lines+=1
                currentwidth=w
        return [lines,currentwidth]