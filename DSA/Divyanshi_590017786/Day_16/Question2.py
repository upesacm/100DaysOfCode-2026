class Solution:
    def deleteLastNode(self, head):
        # If the list is empty
        if head is None:
            return None

        # If there is only one node
        if head.next is None:
            return None

        # Traverse to the last node
        temp = head
        while temp.next:
            temp = temp.next

        # Remove the last node
        temp.prev.next = None

        return head
