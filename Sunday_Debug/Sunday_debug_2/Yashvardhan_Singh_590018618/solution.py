def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]

    concealed = ["*" * len(n) for n in names]

    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")

    clean = password.lower().replace(" ", "")

    if clean == clean[::-1]:  #fix
        initials = [n[0].upper() for n in names]
        print("Scroll unlocked!")  #fix
    else:
        print("Wrong password!")
        return

    print("Initials:", initials)  #fix
    print("Concealed:", concealed)


process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)
