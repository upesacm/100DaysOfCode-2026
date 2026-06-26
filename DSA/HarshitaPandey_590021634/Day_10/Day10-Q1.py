""" Q1: Count distinct characters in a string and print "CHAT WITH HER!" if even, 
"IGNORE HIM!"  if odd.

Example: 
Input: abc ; Output: IGNORE HIM!    """


input_string = input("Enter a string: ")


character_set = set(input_string)


length = len(character_set)

if (length %2 == 0):
    print("CHAT WITH HER!")

else:
    print("IGNORE HIM!")





