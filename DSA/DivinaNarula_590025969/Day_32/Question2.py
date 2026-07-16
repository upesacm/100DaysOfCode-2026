# Copy From One Stack To Another

n = int(input("Enter the number of elements in the stack: "))

print("Enter the elements from bottom to top:")
original_stack = list(map(int, input().split()))

temp_stack = []
copied_stack = []

while original_stack:
    temp_stack.append(original_stack.pop())

while temp_stack:
    value = temp_stack.pop()
    original_stack.append(value)
    copied_stack.append(value)

print("Copied Stack:")
print(copied_stack)