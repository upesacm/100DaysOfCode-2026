class Solution {
    public Node deleteLast(Node head) {
        // Empty list — nothing to delete
        if (head == null) {
            return null;
        }

        // Single node — deleting it empties the list
        if (head.next == null) {
            return null;
        }

        // Walk to the last node
        Node tail = head;
        while (tail.next != null) {
            tail = tail.next;
        }

        // Unlink it
        tail.prev.next = null;
        tail.prev = null; // optional cleanup, helps GC

        return head;
    }
}
