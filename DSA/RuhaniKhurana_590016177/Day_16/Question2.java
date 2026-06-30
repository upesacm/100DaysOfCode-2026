class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

class Question2 {
    Node deleteLast(Node head) {
        if (head == null) {
            return null;
        }

        if (head.next == null) {
            return null;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;

        return head;
    }
}