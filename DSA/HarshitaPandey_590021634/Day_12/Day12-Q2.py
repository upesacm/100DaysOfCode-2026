
def numberOfLines(widths, s):
    
    line =1
    width=0

    for char in s:
            
        letter_width = widths[ord(char) - ord('a')]


        if width + letter_width <=100:
            width += letter_width

        else:
            line +=1

            width = letter_width

    return[line, width]


widths = [4, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10, 10]
s = "abcdefghijklmnopqrstuvwxyz"

result = numberOfLines(widths, s)
print(result)