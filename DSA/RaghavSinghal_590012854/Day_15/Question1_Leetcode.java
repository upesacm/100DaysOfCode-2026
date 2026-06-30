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
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {
        ListNode sort=new ListNode();
        ListNode ans=sort;
        while(list1!=null && list2!=null)
        {
            if(list1.val<=list2.val)
            {
                sort.next=list1;
                sort=sort.next;
                list1=list1.next;
            }
            else
            {
                sort.next=list2;
                sort=sort.next;
                list2=list2.next;
            }
        }
        while(list1!=null) 
        {
            sort.next=list1;
            list1=list1.next;
                sort=sort.next;

        }
        while(list2!=null)
        {
            sort.next=list2;
            list2=list2.next;
                sort=sort.next;

        }

        return ans.next;
    }
}