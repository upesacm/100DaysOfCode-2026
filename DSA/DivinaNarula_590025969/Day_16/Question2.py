# Delete Last Node of a Doubly Linked List.

class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None


def create_list(values):
    if not values:
        return None

    head = Node(values[0])
    current = head

    for value in values[1:]:
        new_node = Node(value)
        current.next = new_node
        new_node.prev = current
        current = new_node

    return head


def delete_last_node(head):
    if head is None:
        return None

    if head.next is None:
        return None

    current = head
    while current.next:
        current = current.next

    current.prev.next = None

    return head


def display(head):
    if head is None:
        print("List is empty.")
        return

    current = head
    while current:
        print(current.data, end="")
        if current.next:
            print(" <-> ", end="")
        current = current.next
    print()


numbers = list(map(int, input("Enter the elements: ").split()))

head = create_list(numbers)

print("Original List:")
display(head)

head = delete_last_node(head)

print("After Deleting Last Node:")
display(head)