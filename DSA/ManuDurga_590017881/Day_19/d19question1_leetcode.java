package Day_19;

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class d19question1_leetcode {
    
    public static class Solution {
    public ListNode deleteDuplicates(ListNode head) {
        if (head==null) {
            return head;
        }
        ListNode slow = head;
        ListNode fast = head.next;
        ListNode current = head;
        int count = 0;

        while (current!=null) {
            count++;
            current = current.next;

        }

        for (int i = 0 ; i<count-1 ; i ++ ) {
            if (slow==null){
                return head;
            }
            if (slow.val==fast.val) {
                slow.next=fast.next;
                fast=fast.next;
                
                
            }
            else{
                slow=slow.next;
                fast= fast.next;
            }
        }
        return head;
        

        
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

        Solution sol = new Solution();
        ListNode rotated = sol.deleteDuplicates(list1);

while (rotated != null) {
    System.out.print(rotated.val + " ");
    rotated = rotated.next;
}
System.out.println();
sc.close();}}