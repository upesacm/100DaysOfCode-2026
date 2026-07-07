package Day_19;

import java.util.*;

public class d19question1_technical {
    
    public static class Solution {
    public ListNode middleNode(ListNode head) {
        ListNode slow = head, fast = head;
        while (fast != null && fast.next != null) {
            slow = slow.next;
            fast = fast.next.next;
        }
        return slow;
    }
}
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);

        System.out.print("Enter size of first list: ");
        int n1 = sc.nextInt();
        System.out.println("Enter elements of first list:");
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
ListNode middle = sol.middleNode(list1);

System.out.println(middle.val);
sc.close();}}