import java.util.Scanner;
class Node 
{
    int data;
    Node next;
    Node(int data) 
    {
        this.data = data;
    }
}

public class Question2 
{

    static Node reverse(Node head) 
    {
        Node prev = null;
        Node curr = head;

        while (curr != null) 
        {
            Node next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    static void display(Node head) 
    {
        while (head != null) 
        {
            System.out.print(head.data);
            if (head.next != null)
                System.out.print(" -> ");
            head = head.next;
        }
    }

    public static void main(String[] args) 
    {
        Scanner sc = new Scanner(System.in);
        System.out.println("Enter number of nodes: ");
        int n = sc.nextInt();
        Node head = null, tail = null;
        for (int i = 0; i < n; i++) 
        {
            int val = sc.nextInt();
            Node newNode = new Node(val);
            if (head == null)
                head = tail = newNode;
            else 
            {
                tail.next = newNode;
                tail = newNode;
            }
        }

        head = reverse(head);
        display(head);
        sc.close();
    }
}
