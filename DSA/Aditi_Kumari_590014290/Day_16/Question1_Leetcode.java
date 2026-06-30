package Day_16;
class ListNode {
    int val;
    ListNode next;
    ListNode() {}
    ListNode(int val) { this.val = val; }
    ListNode(int val, ListNode next) { this.val = val; this.next = next; }
}
 
class Solution {
    public ListNode swapPairs(ListNode head) { 
        ListNode dummy= new ListNode(0,null);
        ListNode curr=dummy;
        dummy.next=head;

        while(curr.next != null && curr.next.next !=null){
            ListNode first= curr.next;
            ListNode sec= curr.next.next;

            first.next=sec.next;
            sec.next=first;
            curr.next=sec;
            curr=first;
        }
        return dummy.next;
    }
}