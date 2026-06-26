chars = input("Enter the characters ")
s = set(chars)
count = len(s)

if count % 2 == 0:
    print("CHAT WITH HER!")
else:
    print("IGNORE HIM!")