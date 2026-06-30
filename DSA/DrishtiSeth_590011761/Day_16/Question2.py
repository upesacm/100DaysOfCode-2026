class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


def deleteLastNode(head):
    if head is None:
        return None

    if head.next is None:
        return None

    temp = head

    while temp.next:
        temp = temp.next

    temp.prev.next = None

    return head
