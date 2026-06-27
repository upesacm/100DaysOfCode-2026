def modifyString(s):
    vowels = "aeiouAEIOU"
    result = ""
    
    for c in s:
        if c.isalpha() and c not in vowels:
            result += "." + c.lower()
    
    return result