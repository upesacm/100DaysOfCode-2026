import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        prev = next = null;
    }
}

public class Question2 {

    static Node deleteLast(Node head) {
        
        if (head == null)
            return null;

        if (head.next == null)
            return null;

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;

        return head;
    }

    static Node createList(Scanner sc, int n) {

        if (n == 0)
            return null;

        Node head = new Node(sc.nextInt());
        Node curr = head;

        for (int i = 1; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            curr.next = newNode;
            newNode.prev = curr;
            curr = newNode;
        }

        return head;
    }

    static void printList(Node head) {

        if (head == null) {
            System.out.println("NULL");
            return;
        }

        Node temp = head;

        while (temp != null) {
            System.out.print(temp.data);

            if (temp.next != null)
                System.out.print(" <-> ");

            temp = temp.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = createList(sc, n);

        head = deleteLast(head);

        printList(head);

        sc.close();
    }
}