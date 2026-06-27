#Modify a string by removing all vowels, converting consonants to lowercase, and adding a dot (.) before each consonant.
#Input:Hello. Output: .h.l.l
def modify(s):
 vowels = "aeiou"
 result = ""

 for ch in s.lower():
    if ch not in vowels:
        result += "." + ch

 print(result)

s=input("Enter a string: ")
modify(s)