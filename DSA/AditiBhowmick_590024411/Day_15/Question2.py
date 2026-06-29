class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def reverse(head):
    prev = None
    current = head

    while current:
        next_node = current.next
        current.next = prev
        prev = current
        current = next_node

    return prev

def display(head):
    while head:
        print(head.data, end="")
        if head.next:
            print(" -> ", end="")
        head = head.next
    print()

# User Input
n = int(input("Enter number of nodes: "))

head = None
tail = None

print("Enter node values:")
for _ in range(n):
    value = int(input())
    new_node = Node(value)

    if head is None:
        head = new_node
        tail = new_node
    else:
        tail.next = new_node
        tail = new_node

print("Original Linked List:")
display(head)

head = reverse(head)

print("Reversed Linked List:")
display(head)