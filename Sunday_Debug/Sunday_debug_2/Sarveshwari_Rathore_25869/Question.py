def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]

    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")

    clean = password.lower().replace(" ", "")

    if clean == clean[::-1]:
        print("Scroll unlocked!")
    else:
        print("Wrong password!")
        return
     
    initials = [n[0].upper() for n in names]
    print("Initials:",initials)
    
    concealed = ["*" * len(n) for n in names]
    print("Concealed:", concealed)


process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)