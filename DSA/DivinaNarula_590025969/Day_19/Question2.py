# Middle of the Linked List

class ListNode:
    def __init__(self, data):
        self.data = data
        self.next = None


def createLinkedList(arr):
    if not arr:
        return None

    head = ListNode(arr[0])
    current = head

    for value in arr[1:]:
        current.next = ListNode(value)
        current = current.next

    return head


def findMiddle(head):
    slow = head
    fast = head

    while fast and fast.next:
        slow = slow.next
        fast = fast.next.next

    return slow


def printList(head):
    current = head
    while current:
        print(current.data, end=" ")
        current = current.next
    print()


n = int(input("Enter the number of nodes: "))

print("Enter the node values:")
values = list(map(int, input().split()))

head = createLinkedList(values)

print("Linked List:")
printList(head)

middle = findMiddle(head)

print("Middle Node:", middle.data)