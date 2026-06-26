# problem 2

username = input("Enter username: ")

distinct = set(username)

if len(distinct) % 2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")