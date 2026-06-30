class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


def deleteLast(head):
    if head is None:
        return None

    # Only one node
    if head.next is None:
        return None

    curr = head

    # Reach the last node
    while curr.next:
        curr = curr.next

    # Remove the last node
    curr.prev.next = None

    return head