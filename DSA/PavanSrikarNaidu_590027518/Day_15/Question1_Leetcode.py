class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None


# Function to merge two sorted linked lists
def mergeTwoLists(list1, list2):
    dummy = ListNode(0)
    current = dummy

    while list1 and list2:
        if list1.val <= list2.val:
            current.next = list1
            list1 = list1.next
        else:
            current.next = list2
            list2 = list2.next

        current = current.next

    # Attach the remaining nodes
    if list1:
        current.next = list1
    else:
        current.next = list2

    return dummy.next


# Function to create linked list from a Python list
def createLinkedList(arr):
    dummy = ListNode(0)
    current = dummy

    for num in arr:
        current.next = ListNode(num)
        current = current.next

    return dummy.next


# Function to print linked list
def printLinkedList(head):
    while head:
        print(head.val, end=" ")
        head = head.next
    print()


# ---------------- Driver Code ----------------
list1 = createLinkedList([1, 2, 4])
list2 = createLinkedList([1, 3, 4])

merged = mergeTwoLists(list1, list2)

print("Merged Linked List:")
printLinkedList(merged)