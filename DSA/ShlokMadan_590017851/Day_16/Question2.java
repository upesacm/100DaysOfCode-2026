public class Question2 {

    static class Node {
        int data;
        Node prev;
        Node next;

        Node(int data) {
            this.data = data;
        }
    }

    public static Node deleteLast(Node head) {

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

        return head;
    }

    public static void printList(Node head) {

        if (head == null) {
            System.out.println("NULL");
            return;
        }

        while (head != null) {

            System.out.print(head.data);

            if (head.next != null) {
                System.out.print(" <-> ");
            }

            head = head.next;
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