# Determine Gender

username = input("Enter username: ")

distinct_chars = len(set(username))

if distinct_chars % 2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")