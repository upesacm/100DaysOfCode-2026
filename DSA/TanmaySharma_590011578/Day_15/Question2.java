import java.util.Scanner;

class ListNode {
    int val;
    ListNode next;

    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class Question2 {

    // Function to reverse the linked list
    public static ListNode reverseList(ListNode head) {
        ListNode prev = null;
        ListNode curr = head;

        while (curr != null) {
            ListNode next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }

        return prev;
    }

    // Function to print the linked list
    public static void printList(ListNode head) {
        while (head != null) {
            System.out.print(head.val);
            if (head.next != null) {
                System.out.print(" -> ");
            }
            head = head.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        // Number of nodes
        int n = sc.nextInt();

        if (n == 0) {
            System.out.println("Empty List");
            return;
        }

        // Create linked list
        ListNode head = new ListNode(sc.nextInt());
        ListNode curr = head;

        for (int i = 1; i < n; i++) {
            curr.next = new ListNode(sc.nextInt());
            curr = curr.next;
        }

        // Reverse the linked list
        head = reverseList(head);

        // Print reversed list
        printList(head);

        sc.close();
    }
}