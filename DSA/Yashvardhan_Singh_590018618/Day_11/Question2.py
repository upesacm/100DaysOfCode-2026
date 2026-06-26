inp = input("Enter a string: ")
def modify_string(inp):
    new = ""
    vowels = "aeiou"
    for i in inp.lower():
        if i not in vowels:
            new += "."+i
    return new

print(modify_string(inp))