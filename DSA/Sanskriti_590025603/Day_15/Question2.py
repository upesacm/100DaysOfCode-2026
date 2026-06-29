class Node:
    def __init__(self, data):
        self.data = data
        self.next = None
def reverse(head):
    prev = None
    current = head

    while current:
        nxt = current.next
        current.next = prev
        prev = current
        current = nxt

    return prev
head = Node(1)
head.next = Node(2)
head.next.next = Node(3)
head.next.next.next = Node(4)
head.next.next.next.next = Node(5)
head = reverse(head)
while head:
    print(head.data, end=" ")
    head = head.next