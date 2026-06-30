class Node:
    def __init__(self, data):
        self.data = data
        self.prev = None
        self.next = None

# Insert at the end
def insert_end(head, data):
    new_node = Node(data)

    if head is None:
        return new_node

    temp = head
    while temp.next:
        temp = temp.next

    temp.next = new_node
    new_node.prev = temp

    return head

# Delete the last node
def delete_last(head):
    if head is None:
        return None

    if head.next is None:
        return None

    temp = head
    while temp.next:
        temp = temp.next

    temp.prev.next = None

    return head

# Display the list
def display(head):
    if head is None:
        print("NULL")
        return

    temp = head
    while temp:
        print(temp.data, end="")
        if temp.next:
            print(" <-> ", end="")
        temp = temp.next
    print()


# Main
head = None

n = int(input("Enter number of nodes: "))

print("Enter node values:")
for _ in range(n):
    value = int(input())
    head = insert_end(head, value)

print("Original List:")
display(head)

head = delete_last(head)

print("Updated List:")
display(head)