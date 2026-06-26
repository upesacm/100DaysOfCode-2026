# problem 2
# String Processing Task

s = input("Enter string: ")

vowels = "aeiou"
output = ""

for ch in s:
    ch = ch.lower()

    if ch not in vowels:
        output += "." + ch

print("Answer is: ", output)