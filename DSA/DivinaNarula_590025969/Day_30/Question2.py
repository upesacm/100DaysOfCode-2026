# Insert Element at Bottom of Stack

def insert_at_bottom(stack, x):
    if not stack:
        stack.append(x)
        return

    top = stack.pop()
    insert_at_bottom(stack, x)
    stack.append(top)

n = int(input("Enter the number of elements in the stack: "))

print("Enter the elements from bottom to top:")
stack = list(map(int, input().split()))

if len(stack) != n:
    print("Error: Number of elements entered does not match n.")
    exit()

x = int(input("Enter the element to insert at the bottom: "))

insert_at_bottom(stack, x)

print("Updated Stack:", stack)