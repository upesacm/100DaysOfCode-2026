class Node {
    int val;
    Node prev;
    Node next;

    Node() {}
    Node(int val) {this.val = val;}
    Node(int val, Node next) { this.val = val; this.next = next; }
}

public class Q2 {

    public Node deleteLastNode(Node head){
        
        if(head == null) return null;

        if(head.next == null) return null;

        Node currNode = head;
        while(currNode.next != null){
            currNode = currNode.next;
        }

        currNode.prev.next = null;

        return head;
    }

    public void printList(Node head) {
        if (head == null) {
            System.out.println("NULL");
            return;
        }
        Node current = head;
        while (current != null) {
            System.out.print(current.val + (current.next != null ? " <-> " : ""));
            current = current.next;
        }
        System.out.println();
    }

    public static void main(String[] args) {
        Q2 dll = new Q2();
        
        // Setup: 1 <-> 2 <-> 3 <-> 4
        Node n1 = new Node(1);
        Node n2 = new Node(2);
        Node n3 = new Node(3);
        Node n4 = new Node(4);
        
        n1.next = n2; n2.prev = n1;
        n2.next = n3; n3.prev = n2;
        n3.next = n4; n4.prev = n3;

        System.out.print("Original: ");
        dll.printList(n1);
        
        Node updatedHead = dll.deleteLastNode(n1);
        
        System.out.print("Updated: ");
        dll.printList(updatedHead);
    }

}

