class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


class Solution:
    def segregateEvenOdd(self, head):
        if head is None:
            return head

        evenStart = evenEnd = None
        oddStart = oddEnd = None

        current = head

        while current:
            nextNode = current.next
            current.next = None

            if current.val % 2 == 0:
                if evenStart is None:
                    evenStart = evenEnd = current
                else:
                    evenEnd.next = current
                    evenEnd = current
            else:
                if oddStart is None:
                    oddStart = oddEnd = current
                else:
                    oddEnd.next = current
                    oddEnd = current

            current = nextNode

        if evenStart is None:
            return oddStart

        evenEnd.next = oddStart

        return evenStart


def createLinkedList(arr):
    if not arr:
        return None

    head = ListNode(arr[0])
    temp = head

    for i in range(1, len(arr)):
        temp.next = ListNode(arr[i])
        temp = temp.next

    return head


def printLinkedList(head):
    while head:
        print(head.val, end=" -> ")
        head = head.next
    print("None")


arr = [17, 15, 8, 9, 2, 4, 6]

head = createLinkedList(arr)

print("Original Linked List:")
printLinkedList(head)

sol = Solution()
head = sol.segregateEvenOdd(head)

print("Modified Linked List:")
printLinkedList(head)