def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]

    concealed = ["*" * len(n) for n in names]

    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")

    clean = password.lower().replace(" ", "")

    # Fix 1: Correct the palindrome check slicing from [::1] to [::-1]
    if clean == clean[::-1]:
        print("Scroll unlocked!") # Fix 2: Added missing print statement
        initials = [n[0].upper() for n in names]
        print("Initials:", initials) # Fix 3: Added missing print statement
    else:
        print("Wrong password!")
        return

    print("Concealed:", concealed)

# Driver call
process_scroll(["Harry", "Ron", "Hermione"], "nurses run", "expelliarmus")