s = input("Enter a string: ")

count = len(set(s))

if count % 2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")