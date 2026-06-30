import java.util.Scanner;
import java.util.*;

public class d15q2 {
    public static void main(String[] args){
        int n = 0;

        LinkedList<Integer> l = new LinkedList<>();
        Scanner s = new Scanner(System.in);
        System.out.println("Enter the size of the list: ");
        n = s.nextInt();

        System.out.println("Enter the elements of the list: ");

        for(int i=0; i<n; i++){
            l.add(s.nextInt());
        }

        l.removeLast();

        if (n>1){
            System.out.println(l);
        }
        else if (n==1){
            System.out.println("null");
        }

    }
}
