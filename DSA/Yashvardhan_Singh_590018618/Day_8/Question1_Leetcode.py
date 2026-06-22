class Solution:
    def isPalindrome(self, s: str) -> bool:
        new = ""
        for i in s:
            for j in i:
                if ord(j) > 64 and ord(j) < 91:
                    new += j
                elif ord(j) > 96 and ord(j) < 123:
                    new += j
                try: 
                    if int(j) >= 0 and int(j) <10:
                        new += j
                except:
                    pass
        
        return new.lower() == new[::-1].lower()