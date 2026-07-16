package Day_30;

import java.util.*;

public class d30question2_technical {
    public static void main(String[] args) {

       Scanner sc = new Scanner(System.in);
       System.out.print("Size of Array: ");
        int n = sc.nextInt();          // size of the input array
        int[] Arr = new int[n];
        for (int i = 0; i < n; i++) {
       System.out.print(": ");
            Arr[i] = sc.nextInt();     // elements of the array
        }
        System.out.print("x = ");
        Stack<Integer> stack = new Stack<>();
        stack.push(sc.nextInt());

        for(int i: Arr){stack.push(i);}
        
        System.out.print(stack);

        sc.close();
    }
}
