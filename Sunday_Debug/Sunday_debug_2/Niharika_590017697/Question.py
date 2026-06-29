def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]
    concealed = ["*" * len(n) for n in names]

    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")
        return # to stop execution when it's invalid

    clean = password.lower().replace(" ", "")

    # using [::-1] to reverse the string
    if clean == clean[::-1]:
        print("Scroll unlocked!")   # was missing output statement earlier
        initials = [n[0].upper() for n in names]
        print("Initials:", initials)   # to display initials
    else:
        print("Wrong password!")
        return

    print("Concealed:", concealed)


process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)