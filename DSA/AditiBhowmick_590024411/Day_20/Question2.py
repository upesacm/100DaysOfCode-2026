class Node:
    def __init__(self, data):
        self.data = data
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
    return head

# Rearrange even nodes before odd nodes
def rearrange(head):
    if head is None:
        return None

    even_head = even_tail = None
    odd_head = odd_tail = None

    current = head

    while current:
        next_node = current.next
        current.next = None

        if current.data % 2 == 0:
            if even_head is None:
                even_head = even_tail = current
            else:
                even_tail.next = current
                even_tail = current
        else:
            if odd_head is None:
                odd_head = odd_tail = current
            else:
                odd_tail.next = current
                odd_tail = current

        current = next_node

    if even_head is None:
        return odd_head

    even_tail.next = odd_head
    return even_head

# Display linked list
def display(head):
    while head:
        print(head.data, end="")
        if head.next:
            print(" -> ", end="")
        head = head.next
    print()

# Main
head = None

n = int(input("Enter number of nodes: "))

print("Enter node values:")
for _ in range(n):
    value = int(input())
    head = insert_end(head, value)

print("Original Linked List:")
display(head)

head = rearrange(head)

print("Modified Linked List:")
display(head)