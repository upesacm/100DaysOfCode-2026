class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
    }
}

public class Question2 {

    static Node deleteLast(Node head) {
        if (head == null || head.next == null)
            return null;

        Node temp = head;
        while (temp.next != null)
            temp = temp.next;

        temp.prev.next = null;
        return head;
    }

    static void print(Node head) {
        while (head != null) {
            System.out.print(head.data + " ");
            head = head.next;
        }
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

        print(head);
    }
}