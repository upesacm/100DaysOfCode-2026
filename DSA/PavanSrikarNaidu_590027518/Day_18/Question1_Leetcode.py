# Day 18 - Rotate Linked List
class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None


class Solution:
    def rotateRight(self, head, k):
        if not head or not head.next or k == 0:
            return head

        length = 1
        tail = head

        while tail.next:
            tail = tail.next
            length += 1

        k = k % length

        if k == 0:
            return head

        tail.next = head

        steps = length - k
        new_tail = head

        for _ in range(steps - 1):
            new_tail = new_tail.next

        new_head = new_tail.next

        new_tail.next = None

        return new_head



def create_linked_list(arr):
    if not arr:
        return None

    head = ListNode(arr[0])
    current = head

    for value in arr[1:]:
        current.next = ListNode(value)
        current = current.next

    return head


def print_linked_list(head):
    while head:
        print(head.val, end=" ")
        head = head.next
    print()



arr = [1, 2, 3, 4, 5]
k = 2

head = create_linked_list(arr)

solution = Solution()
new_head = solution.rotateRight(head, k)

print("Rotated Linked List:")
print_linked_list(new_head)
