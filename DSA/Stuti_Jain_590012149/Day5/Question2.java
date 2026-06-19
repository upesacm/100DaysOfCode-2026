import java.util.Scanner;
import java.util.*;

public class d5q2 {
    public static void main(String[] args){
        int n;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the size of the first array: ");
        n = s.nextInt();

        ArrayList<Integer> a = new ArrayList<>(n);
        System.out.println("Enter the elements of the first array: ");

        for(int i =0; i<n; i++){
            a.add(s.nextInt());
        }

        System.out.println("Enter the size of the second array: ");
        int n2 = s.nextInt();


        ArrayList<Integer> b = new ArrayList<>(n2);
        System.out.println("Enter the elements of the second array: ");

        for(int i =0; i<n2; i++){
            b.add(s.nextInt());
        }

        if(a.equals(b)){
            System.out.println("The arrays are equal.");
        }
        else{
            System.out.println("The arrays are not equal.");
        }
    }
}
