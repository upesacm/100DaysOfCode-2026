username = input("Enter Username:")

if len(set(username)) % 2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")