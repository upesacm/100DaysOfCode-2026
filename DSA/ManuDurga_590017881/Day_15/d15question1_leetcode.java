package Day_15;

import java.util.*;
class ListNode {
    int val;
    ListNode next;
    ListNode(int val) {
        this.val = val;
        this.next = null;
    }
}

public class d15question1_leetcode {
    
    public static class Solution {
    public ListNode mergeTwoLists(ListNode list1, ListNode list2) {

        ListNode copy = new ListNode(-1);
        ListNode current = copy;

        while (list1 != null && list2 != null) {

            if (list1.val <= list2.val) {
                current.next = list1;
                list1 = list1.next;
            } else {
                current.next = list2;
                list2 = list2.next;
            }

            current = current.next;
        }

        if (list1 != null) {
            current.next = list1;
        } else {
            current.next = list2;
        }

        return copy.next;
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

        // Input second list
        System.out.print("Enter size of second list: ");
        int n2 = sc.nextInt();
        System.out.println("Enter elements of second list (sorted):");
        ListNode list2 = null, tail2 = null;
        for (int i = 0; i < n2; i++) {
            ListNode node = new ListNode(sc.nextInt());
            if (list2 == null) {
                list2 = node;
                tail2 = node;
            } else {
                tail2.next = node;
                tail2 = node;
            }
        }
        Solution sol = new Solution();
        ListNode merged = sol.mergeTwoLists(list1, list2);
        System.out.println("Merged List:");
        while (merged != null) {
            System.out.print(merged.val + " ");
            merged = merged.next;
        }
        System.out.println();
    }}
