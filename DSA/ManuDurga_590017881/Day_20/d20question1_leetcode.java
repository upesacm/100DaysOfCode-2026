package Day_20;
import Day_20.ListNode;
import java.util.*;
// class ListNode {
//     int val;
//     ListNode next;
//     ListNode(int val) {
//         this.val = val;
//         this.next = null;
//     }
// }

public class d20question1_leetcode {
    
    public static class Solution {
    public ListNode removeElements(ListNode head, int val) {
        ListNode temp = new ListNode(0);
        temp.next = head;
        ListNode curr = temp;
        while (curr.next != null) 
        {
            if (curr.next.val == val)
                curr.next = curr.next.next; 
            else
                curr = curr.next; 
        }
        return temp.next;
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
        System.out.print("Enter value of n: ");
        int n = sc.nextInt();
        Solution sol = new Solution();
        ListNode rotated = sol.removeElements(list1,n);

while (rotated != null) {
    System.out.print(rotated.val + " ");
    rotated = rotated.next;
}
System.out.println();
sc.close();}}