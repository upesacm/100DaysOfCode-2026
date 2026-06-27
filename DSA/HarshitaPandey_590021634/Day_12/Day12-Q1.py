"""   Q1: Find the length of the shortest substring that contains every distinct character present in the 
given string at least once.

Example:
Input: str= "abcda";  Output: 4    """


word= str(input("Enter the string: "))


count= len(set(word))  
min_len= len(word)  


for i in range(len(word)):
    for j in range(i, len(word)):

        substring = word[i: j+1]

        if len(set(substring)) == count:
            substring_length = len(substring)


            if substring_length < min_len:
                min_len = substring_length

        
        
print(min_len)

        
        



 

