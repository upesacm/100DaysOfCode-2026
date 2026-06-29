sen = input("Enter a name ,only in lower case: ")

dis = {}

for i in sen:
    if i in dis:
        dis[i] += 1
    else:
        dis[i] = 1

if len(dis)%2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")