def determine_gender(username):
    distinct_chars = len(set(username))

    if distinct_chars % 2 == 0:
        return "CHAT WITH HER!"
    else:
        return "IGNORE HIM!"


# Input
username = input()

# Output
print(determine_gender(username))