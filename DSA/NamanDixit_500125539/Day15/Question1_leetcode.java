class ListNode {
    int val;
    ListNode next;

    ListNode() {}

    ListNode(int val) {
        this.val = val;
    }

    ListNode(int val, ListNode next) {
        this.val = val;
        this.next = next;
    }
}

class Question1_leetcode {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        // Create a dummy node
        ListNode dummy = new ListNode(-1);

        // Pointer to build the merged list
        ListNode current = dummy;

        // Traverse both lists
        while (list1 != null && list2 != null) {

            if (list1.val < list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        // Attach the remaining nodes
        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        // Return the merged list (skip dummy node)
        return dummy.next;
    }
}