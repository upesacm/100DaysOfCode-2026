class Solution(object):
    def lengthOfLastWord(self, s):
        rev=s[::-1]
        word=""
        for i in range(len(s)):
            if (rev[i]==" "):
                rev.strip()
            else:
                if ((i+1)==len(s)):
                    word=word+rev[i]
                    return len(word)
                elif (rev[i+1]==" "):
                        word=word+rev[i]
                        return len(word)
                else:
                        word=word+rev[i]