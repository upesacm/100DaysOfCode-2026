import java.util.Scanner;
import java.util.*;

public class d4q2 {
    public static void main(String[] args){
        int target = 0;
        Scanner s = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = s.nextInt();

        ArrayList<Integer> a = new ArrayList<>(n);
        System.out.println("Enter the elements of the array: ");
        for(int i =0; i<n; i++){
            a.add(s.nextInt());
        }

        System.out.println("Enter the value of k: ");
        int k = s.nextInt();

        for(int j = 0; j < k; j++) {
            int temp = a.get(n - 1);

            for(int i = n - 1; i > 0; i--) {
                a.set(i, a.get(i - 1));
            }

            a.set(0, temp);                     //to set temp as the starting element
        }

        System.out.println("Rotated array: " + a);
    }
}
