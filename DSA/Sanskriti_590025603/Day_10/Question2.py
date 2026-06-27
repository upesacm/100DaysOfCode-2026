username = input()
count = len(set(username))
if count % 2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")