def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]

    concealed = ["*" * len(n) for n in names]

    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")

    clean = password.lower().replace(" ", "")

    if clean == clean[::-1]:  # Fix 1 - changed 'clean[::1]' to 'clean[::-1]'. Originally it compared 'clean' with a same copy of itself 'clean[::1]. Now it compares 'clean' with its reverse (clean[::-1])
        print("Scroll unlocked!")  # Fix 2 - added this line so that it can be printed if the password is correct
        initials = [n[0].upper() for n in names]
    else:
        print("Wrong password!")
        return

    print("Initials:", initials) # Fix 3 - added this line to print the initials list
    print("Concealed:", concealed)


process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)