class Solution {
    Node divide(Node head) {
        if (head == null || head.next == null) {
            return head;
        }

        Node evenStart = null, evenEnd = null;
        Node oddStart = null, oddEnd = null;
        Node current = head;

        while (current != null) {
            if (current.data % 2 == 0) {
                if (evenStart == null) {
                    evenStart = current;
                    evenEnd = current;
                } else {
                    evenEnd.next = current;
                    evenEnd = evenEnd.next;
                }
            } else {
                if (oddStart == null) {
                    oddStart = current;
                    oddEnd = current;
                } else {
                    oddEnd.next = current;
                    oddEnd = oddEnd.next;
                }
            }
            current = current.next;
        }

        if (evenStart == null) {
            oddEnd.next = null;
            return oddStart;
        }

        evenEnd.next = oddStart;

        if (oddEnd != null) {
            oddEnd.next = null;
        }

        return evenStart;
    }
}
