# Node class
class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

class Solution:
    def deleteLastNode(self, head):
        # Empty list
        if head is None:
            return None

        # Only one node
        if head.next is None:
            return None

        # Traverse to the last node
        temp = head
        while temp.next:
            temp = temp.next

        # Delete the last node
        temp.prev.next = None

        return head
