class ListNode {
    int val;
    ListNode next;
    ListNode prev;
}
public class Question2 {
    public ListNode deleteLastNode(ListNode head) {
        if (head == null || head.next == null) return null;
        ListNode p = null, c = head;
        while (c.next != null) {
            p = c; c = c.next;
        }
        p.next = null; c.prev = null;
        return head;
    }
}