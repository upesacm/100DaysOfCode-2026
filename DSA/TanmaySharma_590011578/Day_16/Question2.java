package DSA.TanmaySharma_590011578.Day_16;
import java.util.Scanner;

class Node {
    int data;
    Node prev, next;

    Node(int data) {
        this.data = data;
        this.prev = null;
        this.next = null;
    }
}


public class Question2 {
    public static Node deleteLastNode(Node head) {
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

    public static void printList(Node head) {
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
        System.out.println();
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the Number of Nodes");

        int n = sc.nextInt();

        Node head = null, tail = null;
        System.out.println("Enter the nodes :");
        for (int i = 0; i < n; i++) {
            int x = sc.nextInt();
            Node newNode = new Node(x);

            if (head == null) {
                head = tail = newNode;
            } else {
                tail.next = newNode;
                newNode.prev = tail;
                tail = newNode;
            }
        }

        head = deleteLastNode(head);

        printList(head);

        sc.close();
    }
}


