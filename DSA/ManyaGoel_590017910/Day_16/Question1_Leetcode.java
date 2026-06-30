class Question1_Leetcode {
    public ListNode swapPairs(ListNode head) {      
        // Check if the list is empty or has only one node

        if (head == null || head.next == null) {
            return head;
        }
        ListNode newhead = head.next; // The new head will be the second node after the first swap
        ListNode prevpair = null; // To keep track of the previous pair's last node
        ListNode current = head; //

        while (current != null && current.next != null) {
            ListNode secondnode = current.next;    // Current pair to swap   
            ListNode nextpair = secondnode.next;   // First node of the next pair
            // Swap the current pair
            secondnode.next = current;
            current.next = nextpair;
            // Connect the previous swapped pair to the current one
            if (prevpair != null) {
                prevpair.next = secondnode;
            }
            // Move to the next pair
            prevpair = current;
            current = nextpair;
        }
        return newhead;
    }
}