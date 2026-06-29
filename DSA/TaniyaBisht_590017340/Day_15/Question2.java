
class ListNode{
    int val;
    ListNode next;
    ListNode(int val){
        this.val = val;
        this.next = null;
    }
}
class RLL{
    public static ListNode reverseList(ListNode head){
        ListNode prev = null;
        ListNode curr = head;
        while(curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }
    public static void printList(ListNode head){
        while(head != null) {
            System.out.print(head.val);
            if(head.next != null) {
                System.out.print("->");
            }
            head = head.next;
        }
        System.out.println();
    }
    public static void main(String[] args){
        ListNode head = new ListNode(6);
        head.next = new ListNode(7);
        head.next.next = new ListNode(8);
        head.next.next.next = new ListNode(9);
        head.next.next.next.next = new ListNode(10);
        head = reverseList(head);
        System.out.print("Reversed List: ");
        printList(head);
    }
}