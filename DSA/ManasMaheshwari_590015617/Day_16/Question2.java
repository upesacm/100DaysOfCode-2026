class Node {
    int val;
    Node prev;
    Node next;
    Node(int x) { val = x; }
}

class Question2 {
    public static void main(String args[]) {
        Node head = new Node(1);
        head.next = new Node(2);
        head.next.prev = head;
        head.next.next = new Node(3);
        head.next.next.prev = head.next;
        head.next.next.next = new Node(4);
        head.next.next.next.prev = head.next.next;
        
        if (head == null || head.next == null) {
            System.out.println("NULL");
            return;
        }
        
        Node current = head;
        while (current.next != null) {
            current = current.next;
        }
        
        current.prev.next = null;
        current.prev = null;
        
        Node temp = head;
        while (temp != null) {
            System.out.print(temp.val);
            if (temp.next != null) {
                System.out.print(" <-> ");
            }
            temp = temp.next;
        }
    }
}
