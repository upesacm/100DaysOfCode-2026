'''
class ListNode(object):
    def __init__(self, val=0, next=None, prev=None):
        self.val = val
        self.next = next
        self.prev = prev  # Essential for Doubly Linked Lists!

def print_linked_list(head):
    curr = head
    while curr is not None:
        print(curr.val, end=' ')
        curr = curr.next
    print()
'''
def deletelastnode(head):
    if head is None or head.next is None:
        return None
    curr = head
    while curr.next.next is not None:
        curr = curr.next
    curr.next = None
    return head

'''
sample_input = [1, 2, 3, 4, 5]
head = ListNode(sample_input[0])
for i in sample_input[1:]:
    curr = head
    while curr.next is not None:
        curr = curr.next
    curr.next = ListNode(i)
print("Original Linked List:")
print_linked_list(head)
print("Linked List after deleting last node:")
head = deletelastnode(head)
print_linked_list(head)
'''