sen = input("ENter your word in lower or upper case:  ")
sen = sen.lower()

for i in sen:
    if i in "aeiou":
        sen = sen.replace(i, "")

n_sen = ""
for i in sen:        
    if i in "bcdfghjklmnpqrstvwxyz":
        r = "."+i
        n_sen += r

print(n_sen)
