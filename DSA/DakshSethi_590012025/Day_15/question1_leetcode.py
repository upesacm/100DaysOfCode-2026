class ListNode:
    def __init__(self, val=0, next=None):
        self.val = val
        self.next = next


class Solution:
    def mergeTwoLists(self, list1: ListNode, list2: ListNode) -> ListNode:
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

        current.next = list1 or list2

        return dummy.next


def createList(arr):
    dummy = ListNode()
    current = dummy
    for x in arr:
        current.next = ListNode(x)
        current = current.next
    return dummy.next


def printList(head):
    while head:
        print(head.val, end=" -> " if head.next else "")
        head = head.next
    print()


list1 = createList([1, 2, 4])
list2 = createList([1, 3, 4])

obj = Solution()
result = obj.mergeTwoLists(list1, list2)

print("Merged List:")
printList(result)