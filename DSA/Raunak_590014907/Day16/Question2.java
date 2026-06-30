class Node {
    int data;
    Node prev;
    Node next;

    Node(int data) {
        this.data = data;
    }
}

class Solution {

    public Node deleteLast(Node head) {

        // Empty list
        if (head == null) {
            return null;
        }

        // Only one node
        if (head.next == null) {
            return null;
        }

        Node current = head;

        // Reach last node
        while (current.next != null) {
            current = current.next;
        }

        // Delete last node
        current.prev.next = null;

        return head;
    }
}