class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


def delete_last(head):
    # If the list is empty
    if head is None:
        return None

    # If there is only one node
    if head.next is None:
        return None

    # Traverse to the last node
    temp = head
    while temp.next is not None:
        temp = temp.next

    # Remove the last node
    temp.prev.next = None

    return head


def print_list(head):
    if head is None:
        print("NULL")
        return

    temp = head
    while temp is not None:
        print(temp.data, end=" ")
        temp = temp.next
    print()


# Driver Code
head = Node(10)
second = Node(20)
third = Node(30)
fourth = Node(40)

head.next = second
second.prev = head
second.next = third
third.prev = second
third.next = fourth
fourth.prev = third

print("Original List:")
print_list(head)

head = delete_last(head)

print("Updated List:")
print_list(head)