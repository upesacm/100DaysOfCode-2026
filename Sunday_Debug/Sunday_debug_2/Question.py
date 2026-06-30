def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]
    concealed = ["*" * len(n) for n in names]
    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")
        return          # stop execution if spell is invalid
    clean = password.lower().replace(" ", "")
    # Fixed: palindrome check was correct but missing success output
    if clean == clean[::-1]:
        print("Scroll unlocked!")      # Added missing statement
        initials = [n[0].upper() for n in names]
    else:
        print("Wrong password!")
        return
    # initials were created but never displayed
    print("Initials:", initials)
    # Existing statement retained as required
    print("Concealed:", concealed)
process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)
