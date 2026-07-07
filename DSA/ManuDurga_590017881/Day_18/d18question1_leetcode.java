package Day_18;

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class d18question1_leetcode {
    
    public static class Solution {
    public ListNode rotateRight(ListNode head, int k) {
        if (head == null || head.next == null || k == 0) 
        {
            return head;
        }

        int len = 1;
        ListNode tail = head;

        while (tail.next != null) 
        {
            tail = tail.next;
            len++;
        }

        k = k % len;
        if (k == 0)
            return head; 

        tail.next = head;
        int steps = len - k;
        ListNode newTail = head;

        for (int i = 1; i < steps; i++) 
        {
            newTail = newTail.next;
        }

        ListNode newHead = newTail.next;
        newTail.next = null;

        return newHead;
    }
}
    public static void main(String[] args) {
                Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of first list (sorted):");
        ListNode list1 = null, tail1 = null;
        
        for (int i = 0; i < n1; i++) {
            ListNode node = new ListNode(sc.nextInt());
            if (list1 == null) {
                list1 = node;
                tail1 = node;
            } else {
                tail1.next = node;
                tail1 = node;
            }
        }
        System.out.print("Enter k: ");
        int k = sc.nextInt();

        Solution sol = new Solution();
        ListNode rotated = sol.rotateRight(list1, k);

while (rotated != null) {
    System.out.print(rotated.val + " ");
    rotated = rotated.next;
}
System.out.println();
sc.close();}}