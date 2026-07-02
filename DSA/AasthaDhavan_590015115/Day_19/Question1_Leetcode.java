/**
 * Definition for singly-linked list.
 * public class ListNode {
 *     int val;
 *     ListNode next;
 *     ListNode() {}
 *     ListNode(int val) { this.val = val; }
 *     ListNode(int val, ListNode next) { this.val = val; this.next = next; }
 * }
 */
class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if(head==null || head.next==null){
            return head;
        }
        ListNode dummy=new ListNode(head.val);
        ListNode ans=dummy;
        ListNode ptr=head.next;
        while(ptr!=null){
            if(ptr.val!=dummy.val){
                ListNode temp=new ListNode(ptr.val);
                dummy.next=temp;
                dummy=dummy.next;
            }
            ptr=ptr.next;
        }
        return ans;
    }
}