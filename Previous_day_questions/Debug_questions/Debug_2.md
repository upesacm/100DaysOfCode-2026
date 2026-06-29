<h2 align="center">Week 2 Day 14 (28/06/2026) — Weekly Debug 2</h2>

## 1. The Invisibility Cloak Catastrophe

A powerful storm rages outside Hogwarts as Harry, Ron, and Hermione sneak into the Restricted Section under the legendary Invisibility Cloak.

Disaster strikes.

The cloak's enchantment engine has become corrupted after an experimental spell collided with the castle's magical wards. Names are no longer being concealed properly, spell validation is unreliable, and the password system guarding the restricted scrolls is malfunctioning.

Hermione manages to recover the source code, but parts of it are damaged. Some lines contain bugs, while entire sections of code have vanished completely.

Before Filch and Mrs. Norris discover them, you must repair the enchantment engine.

This problem is commonly asked in interviews and helps build concepts like:
- String manipulation
- Palindrome checking
- Conditional logic
- Debugging techniques

which are important for writing correct and reliable programs.

**Your task:** Identify and fix all bugs in the given code so that it produces the correct output.

### What the Code Must Do

- Correctly validate magical spells.
- Conceal every student's name using asterisks.
- Unlock the scroll only when the password is a palindrome.
- Display the initials required for access.
- Produce the expected output exactly.

### Constraints

- Do not add any new functions.
- Do not remove existing statements.
- Fix all syntax, logical, and runtime errors.
- Some code may be missing entirely.
- The output must match exactly.

### Examples

**Input:**
```
(Buggy code with the following function)
process_scroll(names, password, spell)
```
**Output:**
```
Spell accepted!
Scroll unlocked!
Initials: ['H', 'R', 'H']
Concealed: ['*****', '***', '********']
```

### Buggy Code

```python
def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]
    concealed = ["*" * len(n) for n in names]
    if spell in valid_spells:
        print("Spell accepted!")
    else:
        print("Invalid spell!")
    clean = password.lower().replace(" ", "")
    if clean == clean[::1]:
        initials = [n[0].upper() for n in names]
    else:
        print("Wrong password!")
        return
    print("Concealed:", concealed)

process_scroll(
    ["Harry", "Ron", "Hermione"],
    "nurses run",
    "expelliarmus"
)
```
