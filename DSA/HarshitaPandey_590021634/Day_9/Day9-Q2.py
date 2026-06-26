def lengthOfLastWord(s):
    
        length=0

        for i in reversed(range(len(s))):
           if s[i] != ' ':
                length += 1
        

           elif length> 0:
                return length

        return length



print("enter the string: ")

s= input()


length= lengthOfLastWord(s)

print("length of last word: ", length)

        

        



