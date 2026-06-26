def count_distinct(str):
    distinct_chars = set(str)
    if len(distinct_chars) % 2 == 0:
        return "CHAT WITH HER!"
    else:
        return "IGNORE HIM!"

str = input("Enter a string: ")
print(count_distinct(str))