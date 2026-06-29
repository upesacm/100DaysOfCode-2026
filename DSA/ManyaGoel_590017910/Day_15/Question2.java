import java.util.*;
class Node{
        int value;
        Node next;
        Node(int value){
            this.value = value;
            this.next = null;
    }
}
public class Question2{
    public static Node reverse_LinkedList(Node head){
        Node prev=null;
        Node current=head;
        while(current!=null){
            Node nextnode=current.next;
            current.next=prev;
            prev=current;
            current=nextnode;
        }
    return prev;
    }
    public static void print_LinkedList(Node head){
        while(head!=null){
            System.out.print(head.value);
            if(head.next!=null){
                System.out.print(" -> ");
            }
            head=head.next;
        }
        System.out.println(" -> NULL");
    }
    public static void main (String args[]){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter the number of nodes in linked list:");
        int n=sc.nextInt();
        if(n==0){
            System.out.println("Linked list is empty");
            return;
        }
        System.out.println("Enter the values of nodes:");
        Node head=new Node(sc.nextInt());
        Node current=head;
        for(int i=1;i<n;i++){
            current.next=new Node(sc.nextInt());
            current=current.next;         
}
    System.out.println("Original Linked List:");
    print_LinkedList(head);
    Node newHead=reverse_LinkedList(head);
    System.out.println("\nReversed Linked List:");
    print_LinkedList(newHead);
    sc.close();
}
}