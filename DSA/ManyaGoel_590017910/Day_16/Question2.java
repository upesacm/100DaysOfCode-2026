import java.util.*;
// Creating a Node class for the doubly linked list 
class Node {
    int value;
    Node prev;
    Node next;
    Node(int value) {
        this.value = value;
        this.prev = null;
        this.next = null;
    }
}
public class Question2 {
    public static Node delete_Last_Node(Node head) {
        // Check if the list is empty
        if (head == null) {
            return null;
        }
        // Check if there's only one node
        if (head.next == null)  return null;
        Node current = head;
        // Reach the last node
        while (current.next != null) {
            current = current.next;
        }
        // Remove the last node
        current.prev.next = null;
        return head;
    }
    public static void print_DoublyLinkedList(Node head) {
        // Print the doubly linked list
        while (head != null) {
            System.out.print(head.value);
            if (head.next != null) {
                System.out.print(" <-> ");
            }
            head = head.next;
        }
        System.out.println(" -> NULL");
    }
    public static void main(String args[]) {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter the number of nodes in doubly linked list:");
        int n = sc.nextInt();
        if (n == 0) {
            System.out.println("Doubly Linked List is empty");
            return;
        }
        System.out.println("Enter the values of nodes:");
        Node head = new Node(sc.nextInt());
        Node current = head;
        // Create the doubly linked list
        for (int i = 1; i < n; i++) {
            Node newNode = new Node(sc.nextInt());
            current.next = newNode;
            newNode.prev = current;
            current = newNode;
        }
        System.out.println("\nOriginal Doubly Linked List:");
        print_DoublyLinkedList(head);
        head = delete_Last_Node(head);
        System.out.println("\nDoubly Linked List After Deleting Last Node:");
        print_DoublyLinkedList(head);
        sc.close();
    }
}