class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = this.next = null;
    }
}

public class Question2 {

    public static Node deleteLast(Node head) {
        if (head == null) return null;

        if (head.next == null) return null;

        Node temp = head;

        // move to last node
        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
        temp.prev = null;

        return head;
    }
    public static void printList(Node head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }

        Node temp = head;
        while (temp != null) {
            System.out.print(temp.data);
            if (temp.next != null) System.out.print(" <-> ");
            temp = temp.next;
        }
        System.out.println();
    }
    public static void main(String[] args) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;

        head = deleteLast(head);
        printList(head);
    }
}