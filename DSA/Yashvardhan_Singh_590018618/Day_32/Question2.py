class Stack:
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

    def size(self):
        return len(self.items)
    

def copy_stack(st):
    temp = Stack()
    newStack = Stack()

    while not st.is_empty():
        temp.push(st.pop())

    while not temp.is_empty():
        val = temp.pop()
        newStack.push(val)
        st.push(val)

    return newStack

st = Stack()
n = int(input("Enter the number of elements in the array: "))
for i in range(n):
    element = int(input(f"Enter element {i + 1}: "))
    st.push(element)

newStack = copy_stack(st)

print("Original Stack:")
while not st.is_empty():
    print(st.pop(), end=" ")    

print("\nCopied Stack:")
while not newStack.is_empty():
    print(newStack.pop(), end=" ")  