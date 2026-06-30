public class Reverse_ll {
    
    public static class Listnode{
        int val;
        Listnode next;
        Listnode(int val){
            this.val = val;
            this.next = null;
        }
    }

    //method to display linked list
    public static void Display( Listnode head){
        
        Listnode temp = head;
        while(temp != null){
            System.out.print(temp.val + " ");
            temp = temp.next;
        }
        System.out.println();
    }

    //method to reverse linked list
    public static Listnode reverse(Listnode head){
        Listnode prev = null;
        Listnode curr = head;
        Listnode next = null;

        while(curr != null){
            next = curr.next;
            curr.next = prev;
            prev = curr;
            curr = next;
        }
        return prev;
    }

    //creating linked list
    public static void main(String[] args){
        Listnode head = new Listnode(1);
        Listnode temp = head;
        for(int i=2; i<=5; i++){
            temp.next = new Listnode(i);
            temp = temp.next;
        }
        System.out.println("Original linked list is: ");
        Display(head);
        //reversing linked list
        head = reverse(head);
        
        //Displaying reversed linked list
        System.out.println("Reversed linked list is: ");
        Display(head);
    }
}