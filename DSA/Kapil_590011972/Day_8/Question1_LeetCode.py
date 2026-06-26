phrase = input("Enter  the Phrase: ")

left = 0
right = len(phrase)-1
flag = True

while (left<right):
    if not phrase[left].isalnum():
        left+=1
    elif not phrase[right].isalnum():
        right-=1
    elif phrase[left].lower()==phrase[right].lower():
        left+=1
        right-=1
    else:
        flag=False
        break

print(flag)

