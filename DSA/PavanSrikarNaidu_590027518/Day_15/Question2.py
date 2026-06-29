class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None


# Function to reverse the linked list
def reverseLinkedList(head):
    prev = None
    current = head

    while current:
        next_node = current.next   # Store next node
        current.next = prev        # Reverse the link
        prev = current             # Move prev forward
        current = next_node        # Move current forward

    return prev


# Function to create a linked list
def createLinkedList(arr):
    if not arr:
        return None

    head = ListNode(arr[0])
    current = head

    for value in arr[1:]:
        current.next = ListNode(value)
        current = current.next

    return head


# Function to print the linked list
def printLinkedList(head):
    while head:
        print(head.val, end=" ")
        head = head.next
    print()


# ---------------- Driver Code ----------------
head = createLinkedList([1, 2, 3, 4, 5])

print("Original Linked List:")
printLinkedList(head)

head = reverseLinkedList(head)

print("Reversed Linked List:")
printLinkedList(head)