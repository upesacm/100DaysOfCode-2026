# Problem 2 
# Reverse a String Using Stack

s = input("Enter a string: ")
stack = []

for ch in s:
    stack.append(ch)

reverse = ""

while len(stack) > 0:
    reverse = reverse + stack.pop()
    
print("Reversed string:", reverse)