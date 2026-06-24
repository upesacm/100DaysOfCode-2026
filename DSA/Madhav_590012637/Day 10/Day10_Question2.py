def determine_gender(username):
    distinct = set(username)

    if len(distinct) % 2 == 0:
        print("CHAT WITH HER!")
    else:
        print("IGNORE HIM!")


# Example
username = "alex"
determine_gender(username)