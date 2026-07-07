package Day_20;

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class d20question1_technical {
    
    public static ListNode insert(ListNode head, int data) 
    {
        ListNode newNode = new ListNode(data);
        if (head == null)
            return newNode;

        ListNode temp = head;
        while (temp.next != null) 
            temp = temp.next;

        temp.next = newNode;
        return head;
    }

    static ListNode seperateEvenOdd(ListNode head) 
    {
        if (head == null || head.next == null)
            return head;

        ListNode evenHead = null, evenTail = null;
        ListNode oddHead = null, oddTail = null;
        ListNode curr = head;

        while (curr != null) 
        {
            if (curr.val % 2 == 0) 
            {
                if (evenHead == null) 
                {
                    evenHead = curr;
                    evenTail = curr;
                } 
                else 
                {
                    evenTail.next = curr;
                    evenTail = curr;
                }
            } 
            else 
            {
                if (oddHead == null) 
                {
                    oddHead = curr;
                    oddTail = curr;
                } 
                else 
                {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }
            curr = curr.next;
        }
        if (evenHead == null) 
        {
            oddTail.next = null;
            return oddHead;
        }
        if (oddHead == null) 
        {
            evenTail.next = null;
            return evenHead;
        }
        evenTail.next = oddHead;
        oddTail.next = null;

        return evenHead;
    }

    static void display(ListNode head) 
    {
        ListNode temp = head;
        while (temp != null) 
        {
            System.out.print(temp.val);
            if (temp.next != null)
                System.out.print(" -> ");
            temp = temp.next;
        }
        System.out.println();
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        ListNode head = null;

        System.out.println("Enter ListNode values:");
        for (int i = 0; i < n; i++) 
        {
            int value = sc.nextInt();
            head = insert(head, value);
        }

        head = seperateEvenOdd(head);
        System.out.print("Output: ");
        display(head);

        sc.close();
    }
}
