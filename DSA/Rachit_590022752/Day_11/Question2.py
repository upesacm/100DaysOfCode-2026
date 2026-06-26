def process_string(s: str) -> str:
    vowels = set("aeiouAEIOU")
    result = ""
    for ch in s:
        if ch not in vowels:
            result += "." + ch.lower()
    return result

user_input = input("Enter a string: ")
print(process_string(user_input))
