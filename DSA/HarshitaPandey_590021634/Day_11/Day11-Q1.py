""" Q1: Modify a string by removing all vowels, converting consonants to lowercase, and adding a dot (.) before each consonant.

Example
Input:Hello. Output: .h.l.l   """



word= str(input("Enter a string: "))

vowels = "aeiouAEIOU"
result = ""

if len(word) == 0:
    print("Empty string provided.")


for char in word:
    if char not in vowels and char.isalpha():
        result += "."  +char.lower()


print(result)

