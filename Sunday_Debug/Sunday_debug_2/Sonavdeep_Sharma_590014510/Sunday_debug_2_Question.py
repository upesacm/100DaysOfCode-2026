def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]

    concealed = []

    for name in names:
        concealed.append("*" * len(name))

    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")
        return

    clean = password.lower().replace(" ", "")

    if clean == clean[::-1]:
        print("Scroll unlocked!")
        initials = []

        for name in names:
            initials.append(name[0].upper())
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