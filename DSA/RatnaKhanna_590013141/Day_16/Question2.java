import java.util.Scanner;
class Node {
    int data;
    Node prev, next;
    Node(int data) {
        this.data = data;
        prev = null;
        next = null;
    }
}
public class Main {
    static Node insert(Node head, int data) {
        Node newNode = new Node(data);
        if (head == null) {
            return newNode;
        }
        Node temp = head;
        while (temp.next != null) {
            temp = temp.next;
        }
        temp.next = newNode;
        newNode.prev = temp;
        return head;
    }
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
        temp.prev = null;
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
        System.out.println();
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();
        Node head = null;
        if (n > 0) {
            System.out.println("Enter node values:");
            for (int i = 0; i < n; i++) {
                int value = sc.nextInt();
                head = insert(head, value);
            }
        }
        head = deleteLast(head);
        System.out.println("Updated Doubly Linked List:");
        printList(head);
        sc.close();
    }
}
