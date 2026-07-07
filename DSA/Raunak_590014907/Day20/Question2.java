class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        next = null;
    }
}

class Solution {

    public Node segregateEvenOdd(Node head) {

        if (head == null || head.next == null) {
            return head;
        }

        Node evenHead = null, evenTail = null;
        Node oddHead = null, oddTail = null;

        Node curr = head;

        while (curr != null) {

            if (curr.data % 2 == 0) {

                if (evenHead == null) {
                    evenHead = curr;
                    evenTail = curr;
                } else {
                    evenTail.next = curr;
                    evenTail = curr;
                }

            } else {

                if (oddHead == null) {
                    oddHead = curr;
                    oddTail = curr;
                } else {
                    oddTail.next = curr;
                    oddTail = curr;
                }
            }

            curr = curr.next;
        }

        if (evenHead == null)
            return oddHead;

        if (oddHead == null)
            return evenHead;

        evenTail.next = oddHead;
        oddTail.next = null;

        return evenHead;
    }
}