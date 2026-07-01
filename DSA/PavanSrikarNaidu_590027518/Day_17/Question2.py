class ListNode:
    def __init__(self, val=0):
        self.val = val
        self.next = None


class Solution:
    def hasCycle(self, head):
        slow = head
        fast = head

        while fast and fast.next:
            slow = slow.next
            fast = fast.next.next

            if slow == fast:
                return True

        return False


# -------- Driver Code --------

# Create nodes
nodes = [ListNode(3), ListNode(2), ListNode(0), ListNode(-4)]

# Connect nodes
for i in range(len(nodes) - 1):
    nodes[i].next = nodes[i + 1]

# Create cycle
pos = 1      # Change to -1 for no cycle

if pos != -1:
    nodes[-1].next = nodes[pos]

head = nodes[0]

obj = Solution()
print(obj.hasCycle(head))