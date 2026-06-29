# Buggy Code
# def process_scroll(names, password, spell):
# valid_spells = ["nox", "expelliarmus", "alohomora"]
# concealed = ["*" * len(n) for n in names]
# if spell in valid_spells:
# print("Spell accepted!")
# else:
# print("Invalid spell!")
# clean = password.lower().replace(" ", "")
# if clean == clean[::1]:
# initials = [n[0].upper() for n in names]
# else:
# print("Wrong password!")
# return
# print("Concealed:", concealed)
# process_scroll(
# ["Harry", "Ron", "Hermione"],
# "nurses run",
# "expelliarmus"
# )
# Expected

# Correct Code

def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]
    concealed = ["*" * len(n) for n in names]
    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")
    clean = password.lower().replace(" ", "")
    #Fixed the slicing for reverse
    if clean == clean[::-1]:          
        #Print statement which was missed, now added
        print("Scroll unlocked!")     
        initials = [n[0].upper() for n in names]
        #Initial print statement was missed
        print("Initials:", initials)  
        print("Wrong password!")
        return
    print("Concealed:", concealed)

process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)
