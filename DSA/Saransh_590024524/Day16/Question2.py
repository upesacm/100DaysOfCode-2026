class Solution:
    def deleteLastNode(self, head):
        if head is None:
            return None

        temp = head
        while temp.next is not None:
            temp = temp.next

        temp.prev.next = None

        return head