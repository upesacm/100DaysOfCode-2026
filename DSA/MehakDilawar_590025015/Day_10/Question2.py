#Count distinct characters in a string and print "CHAT WITH HER!" if even, "IGNORE HIM!" if odd.
#Input:abc. Output:IGNORE HIM!
def gender(str):
    ch=[]
    for i in str:
        if i in ch:
            continue
        else:
            ch.append(i)
    if len(set(ch))%2==0:
        print("CHAT WITH HER!")
    else:
        print("IGNORE HIM!")
str=input("Enter a string: ")
gender(str)