string = "c od ing"
def removeSpace(string: str) -> str:

    for i in string:
        if i == " ":
            string = string.replace(i, "")
           
    return string

print(removeSpace(string))

