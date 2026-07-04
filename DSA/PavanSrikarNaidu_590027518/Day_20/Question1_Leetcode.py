class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def removeElements(self, head, val):
        dummy = ListNode(0)
        dummy.next = head

        current = dummy

        while current.next:
            if current.next.val == val:
                current.next = current.next.next
            else:
                current = current.next

        return dummy.next


def createLinkedList(arr):
    dummy = ListNode()
    curr = dummy
    for x in arr:
        curr.next = ListNode(x)
        curr = curr.next
    return dummy.next


def printLinkedList(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")


head = createLinkedList([1, 2, 6, 3, 4, 5, 6])
val = 6

sol = Solution()
newHead = sol.removeElements(head, val)

printLinkedList(newHead)