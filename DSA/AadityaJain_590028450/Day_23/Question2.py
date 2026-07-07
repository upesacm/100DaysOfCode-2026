'''Backspace Equality
Explanation
Process both strings by treating # as a backspace and return true if the resulting strings are identical; otherwise, return false'''

def backspace(a):
    str = []

    for ch in a:
        if ch == '#':
            if str:
                str.pop()
        else:
            str.append(ch)

    return str


s = input("Enter first string: ")
t = input("Enter second string: ")


if backspace(s) == backspace(t):
    print("True")
else:
    print("False")