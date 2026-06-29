def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]
    concealed = ["*" * len(name) for name in names]
    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")
        return
    clean = password.lower().replace(" ", "")
    if clean == clean[::-1]:
        print("Scroll unlocked!")
        initials = [name[0].upper() for name in names]
    else:
        print("Wrong password!")
        return
    print("Initials:", initials)
    print("Concealed:", concealed)

process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)
