text = input("Enter a string: ")

result = ""

for ch in text:
    if ch != " ":      
        result += ch   

print("String after removing spaces:", result)