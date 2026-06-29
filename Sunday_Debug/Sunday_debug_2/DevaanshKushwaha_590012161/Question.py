def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]
    concealed = ["*" * len(n) for n in names]
    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")
    clean = password.lower().replace(" ", "")
    if clean == clean[::-1]:          # FIX 1: [::-1] to actually reverse the string
        print("Scroll unlocked!")     # FIX 2: missing print
        initials = [n[0].upper() for n in names]
        print("Initials:", initials)  # FIX 3: moved here, was missing entirely
    else:
        print("Wrong password!")
        return
    print("Concealed:", concealed)

process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)
