# Reverse a Singly Linked List

class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


def reverse_linked_list(head):
    previous = None
    current = head

    while current is not None:
        next_node = current.next    
        current.next = previous    
        previous = current         
        current = next_node        

    return previous


def print_list(head):
    while head is not None:
        print(head.data, end="")
        if head.next:
            print(" -> ", end="")
        head = head.next
    print()


values = list(map(int, input("Enter the linked list elements: ").split()))

head = None
tail = None

for value in values:
    new_node = Node(value)

    if head is None:
        head = new_node
        tail = new_node
    else:
        tail.next = new_node
        tail = new_node

print("\nOriginal Linked List:")
print_list(head)

head = reverse_linked_list(head)

print("Reversed Linked List:")
print_list(head)