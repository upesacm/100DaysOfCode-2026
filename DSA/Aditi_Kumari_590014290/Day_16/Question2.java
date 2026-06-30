package Day_16;

class ListNode {
    int data;
    ListNode next;
    ListNode prev;

    ListNode(int data) {
        this.data = data;
    }
}

public class Question2 {
    public ListNode del(ListNode head){
        if (head == null || head.next ==null){
            return null;
        }
        ListNode curr = head;
        while(curr.next != null){
            curr=curr.next;
        }
        curr.prev.next=null;
        return head;
    }
    
}
