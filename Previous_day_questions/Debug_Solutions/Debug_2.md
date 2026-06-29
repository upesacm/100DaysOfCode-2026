<h2 align="center">Week 2 Day 14 (28/06/2026) — Weekly Debug 2</h2>

## 1. The Invisibility Cloak Catastrophe

### Solution

```python
def process_scroll(names, password, spell):
    valid_spells = ["nox", "expelliarmus", "alohomora"]
    # BUG: Spell validation was case-sensitive.
    # Incorrect: if spell in valid_spells:
    if spell.lower() in valid_spells:
        print("Spell accepted!")
    else:
        # BUG: The function did not stop after an invalid spell, allowing the remaining code to execute.
        print("Invalid spell!")
        return
    concealed = ["*" * len(n) for n in names]
    clean = password.lower().replace(" ", "")
    # BUG: Palindrome check used clean[::1], which just copies the string instead of reversing it.
    # Incorrect: if clean == clean[::1]:
    if clean == clean[::-1]:
        # BUG: Missing confirmation message when the scroll is successfully unlocked.
        print("Scroll unlocked!")
        initials = [n[0].upper() for n in names]
        # BUG: Initials were computed but never printed.
        print("Initials:", initials)
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
