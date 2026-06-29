def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]

    concealed = ["*" * len(n) for n in names]

    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")

    clean = password.lower().replace(" ", "")

    if clean == clean[::-1]:          # Fix 1: [::-1] reverses, [::1] doesn't
        print("Scroll unlocked!")     # Fix 2: missing line added
        initials = [n[0].upper() for n in names]
    else:
        print("Wrong password!")
        return

    print("Initials:", initials)      # Fix 3: was missing entirely
    print("Concealed:", concealed)