import java.util.Scanner;

class Node {
    int data;
    Node next;

    Node(int data) {
        this.data = data;
        this.next = null;
    }
}

public class Main {

    // Reverse Linked List
    public static Node reverseList(Node head) {

        Node prev = null;
        Node curr = head;
        Node next = null;

        while (curr != null) {

            next = curr.next;      // Save next node

            curr.next = prev;      // Reverse the link

            prev = curr;           // Move prev

            curr = next;           // Move current
        }

        return prev;
    }

    // Print Linked List
    public static void printList(Node head) {

        while (head != null) {

            System.out.print(head.data);

            if (head.next != null)
                System.out.print("->");

            head = head.next;
        }
    }

    public static void main(String[] args) {

        Scanner sc = new Scanner(System.in);

        int n = sc.nextInt();

        Node head = null;
        Node tail = null;

        for (int i = 0; i < n; i++) {

            int value = sc.nextInt();

            Node newNode = new Node(value);

            if (head == null) {
                head = newNode;
                tail = newNode;
            } else {
                tail.next = newNode;
                tail = newNode;
            }
        }

        head = reverseList(head);

        printList(head);

        sc.close();
    }
}