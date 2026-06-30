class Solution {
    public ListNode swapPairs(ListNode head) {
        ListNode dummy = new ListNode(0, head);
        ListNode p = dummy;
        while (p.next != null && p.next.next != null) {
            ListNode c = p.next.next;
            p.next.next = c.next;
            c.next = p.next;
            p.next = c;
            p = c.next;
        }
        return dummy.next;
    }
}