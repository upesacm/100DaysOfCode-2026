import java.util.Scanner;
import java.util.*;

public class d3q2 {
    public static void main(String[] args) {
        int target = 0;

        Scanner s = new Scanner(System.in);

        System.out.println("Enter the size of the array: ");
        int n = s.nextInt();

        ArrayList<Integer> a = new ArrayList<>(n);
        System.out.println("Enter the elements of the array: ");

        for (int i = 0; i < n; i++) {
            a.add(s.nextInt());
        }

        Collections.sort(a);


        int count = 0;

        System.out.println("Enter the element to search: ");
        target = s.nextInt();

        for(int i =0; i<n; i++){
            if(a.get(i) == target){
                count++;
            }

        }

        System.out.println(target + " occurs " + count + " times in the array.");

        s.close();
    }

}
