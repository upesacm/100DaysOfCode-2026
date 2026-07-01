class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def isPalindrome(self, head):
        values = []

        current = head
        while current:
            values.append(current.val)
            current = current.next

        return values == values[::-1]


# -------- Driver Code --------

def createLinkedList(arr):
    if not arr:
        return None

    head = ListNode(arr[0])
    current = head

    for value in arr[1:]:
        current.next = ListNode(value)
        current = current.next

    return head


arr = list(map(int, input("Enter linked list elements: ").split()))

head = createLinkedList(arr)

obj = Solution()

print(obj.isPalindrome(head))