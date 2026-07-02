class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None


class Solution:
    def removeNthFromEnd(self, head, n):
        dummy = ListNode(0)
        dummy.next = head

        fast = dummy
        slow = dummy

        for _ in range(n + 1):
            fast = fast.next

        while fast:
            fast = fast.next
            slow = slow.next

        slow.next = slow.next.next

        return dummy.next


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
n = 2

head = create_linked_list(arr)

solution = Solution()
new_head = solution.removeNthFromEnd(head, n)

print("Updated Linked List:")
print_linked_list(new_head)