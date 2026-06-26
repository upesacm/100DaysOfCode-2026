s = input("Enter a string: ")

# s = "".join(alpha for alpha in s if alpha.isalpha())

for i in s:
    if i == " ":
        s = s.replace(i, "")

print(s)