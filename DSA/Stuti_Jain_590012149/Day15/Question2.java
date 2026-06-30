import java.util.*;
import java.util.Scanner;

class d14q2{
    public static void main(String[] args) {

        LinkedList<Integer> ll = new LinkedList<>();

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the elements of the list: ");
        for(int i =0; i<6; i++){
            ll.add(s.nextInt());
        }

        Collections.reverse(ll);

        System.out.println("Reversed list: " + ll);

     }
}
