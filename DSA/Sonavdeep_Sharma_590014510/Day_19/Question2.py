class ListNode:
    def __init__(self, val):
        self.val = val
        self.next = None

n = int(input("Enter number of nodes: "))
values = list(map(int, input("Enter node values separated by spaces: ").split()))

head = ListNode(values[0])
current = head

for i in range(1, n):
    current.next = ListNode(values[i])
    current = current.next

slow = head
fast = head

while fast and fast.next:
    slow = slow.next
    fast = fast.next.next

print("Middle node:", slow.val)