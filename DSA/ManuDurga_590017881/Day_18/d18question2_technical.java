package Day_18;
import java.util.*;

class Node {
    int val;
    Node next;

    Node(int val) {
        this.val = val;
        this.next = null;
    }
}

public class d18question2_technical {

    static ListNode remove(ListNode head, int n) 
    {
        ListNode temp = new ListNode(0);
        temp.next = head;

        ListNode fast = temp;
        ListNode slow = temp;

        for (int i = 0; i <= n; i++) 
        {
            if (fast == null)
                return head;
            fast = fast.next;
        }

        while (fast != null) 
        {
            fast = fast.next;
            slow = slow.next;
        }

        slow.next = slow.next.next;

        return temp.next;
    }

    static void printList(ListNode head) 
    {
        if (head == null) 
        {
            System.out.println("List is empty");
            return;
        }

        while (head != null) 
        {
            System.out.print(head.val);

            if (head.next != null)
                System.out.print(" ");

            head = head.next;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter size of list: ");
        int s = sc.nextInt();

        if (s == 0) 
        {
            System.out.println("List is empty");
            return;
        }

        System.out.print("Enter elements: ");
        ListNode head = new ListNode(sc.nextInt());
        ListNode temp = head;

        for (int i = 1; i < s; i++) 
        {
            temp.next = new ListNode(sc.nextInt());
            temp = temp.next;
        }

        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        head = remove(head, n);
        printList(head);

        sc.close();
    }
}