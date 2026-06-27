def process_string(s):
    vowels = "aeiouAEIOU"
    result = []

    for char in s:
        if char not in vowels:
            result.append( "." + char.lower())
    
    return "".join(result)

str = input("Enter a string: ")
print(process_string(str))