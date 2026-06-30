public class Problem2 {
    static class Node {
        int data;
        Node prev;
        Node next;
        Node(int data) {
            this.data = data;
        }
    }
    public Node deleteLast(Node head) {
        if (head == null) {
            return null;
        }
        if (head.next == null) {
            return null;
        }
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        current.prev.next = null;
        current.prev = null;
        return head;
    }
}