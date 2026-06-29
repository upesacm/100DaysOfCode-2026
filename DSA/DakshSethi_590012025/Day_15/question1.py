class Node:
    def __init__(self, data):
        self.data = data
        self.next = None

def reverse(head):
    prev = None
    curr = head

    while curr is not None:
        next_node = curr.next
        curr.next = prev
        prev = curr
        curr = next_node

    return prev

def print_list(head):
    while head:
        print(head.data, end=" ")
        head = head.next
    print()

head = Node(10)
head.next = Node(20)
head.next.next = Node(30)
head.next.next.next = Node(40)

print("Original List:")
print_list(head)

head = reverse(head)

print("Reversed List:")
print_list(head)