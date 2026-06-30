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

    Node head = null;

    // Insert at the end
    void insertEnd(int data) {
        Node newNode = new Node(data);

        if (head == null) {
            head = newNode;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.next = newNode;
        newNode.prev = temp;
    }

    // Delete the last node
    void deleteLast() {

        if (head == null) {
            System.out.println("List is empty.");
            return;
        }

        // Only one node
        if (head.next == null) {
            head = null;
            return;
        }

        Node temp = head;

        while (temp.next != null) {
            temp = temp.next;
        }

        temp.prev.next = null;
    }

    // Display the list
    void display() {

        if (head == null) {
            System.out.println("List is empty.");
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

        Main list = new Main();

        System.out.print("Enter number of nodes: ");
        int n = sc.nextInt();

        System.out.println("Enter node values:");

        for (int i = 0; i < n; i++) {
            int data = sc.nextInt();
            list.insertEnd(data);
        }

        System.out.println("\nOriginal List:");
        list.display();

        list.deleteLast();

        System.out.println("\nAfter Deleting Last Node:");
        list.display();

        sc.close();
    }
}
