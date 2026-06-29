public class Question2 {
    public ListNode reverseList(ListNode head) {
        ListNode p = null;
        ListNode c = head;
        while (c != null) {
            ListNode next = c.next;
            c.next = p; 
            p = c; c = next;               
        } return p;
    }
}