class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question2 {

    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;     // will become new head
        ListNode curr = head;     // start from original head

        while (curr != null) {
            ListNode nextTemp = curr.next; // store next node
            curr.next = prev;              // reverse link
            prev = curr;                  // move prev forward
            curr = nextTemp;              // move curr forward
        }

        return prev; // new head
    }

    // Helper function to print list
    public static void printList(ListNode head) {
        ListNode temp = head;
        while (temp != null) {
            System.out.print(temp.val + " -> ");
            temp = temp.next;
        }
        System.out.println("null");
    }

    public static void main(String[] args) {
        // Create sample list: 1 -> 2 -> 3 -> 4 -> 5
        ListNode head = new ListNode(1);
        head.next = new ListNode(2);
        head.next.next = new ListNode(3);
        head.next.next.next = new ListNode(4);
        head.next.next.next.next = new ListNode(5);

        System.out.print("Original: ");
        printList(head);

        head = reverseList(head);

        System.out.print("Reversed: ");
        printList(head);
    }
}