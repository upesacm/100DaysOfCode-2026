class stack:
    def __init__(self):
        self.items = []

    def is_empty(self):
        return len(self.items) == 0

    def push(self, item):
        self.items.append(item)

    def pop(self):
        if not self.is_empty():
            return self.items.pop()
        else:
            raise IndexError("pop from empty stack")

    def peek(self):
        if not self.is_empty():
            return self.items[-1]
        else:
            raise IndexError("peek from empty stack")

stack = stack()


n = int(input("Enter the number of elements to push onto the stack: "))
for i in range(n):
    element = int(input(f"Enter element {i + 1}: "))
    stack.push(element)


def insert_bottom(stack, x):
    if stack.is_empty():
        stack.push(x)
    else:
        temp = stack.pop()
        insert_bottom(stack, x)
        stack.push(temp)

x = int(input("Enter the element to insert at the bottom of the stack: "))
insert_bottom(stack, x)

print(stack.items)