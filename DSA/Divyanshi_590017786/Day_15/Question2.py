class Node:
    def __init__(self, data):
        self.data = data
        self.next = None


def reverseList(head):
    prev = None
    curr = head

    while curr:
        next_node = curr.next
        curr.next = prev
        prev = curr
        curr = next_node

    return prev


def printList(head):
    while head:
        print(head.data, end=" ")
        head = head.next
    print()


# Creating the linked list: 1 -> 2 -> 3 -> 4 -> 5
head = Node(1)
head.next = Node(2)
head.next.next = Node(3)
head.next.next.next = Node(4)
head.next.next.next.next = Node(5)

print("Original Linked List:")
printList(head)

# Reverse the linked list
head = reverseList(head)

print("Reversed Linked List:")
printList(head)
