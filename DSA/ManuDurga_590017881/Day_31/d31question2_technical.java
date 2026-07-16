package Day_31;

import java.util.*;

public class d31question2_technical {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Size of Array: ");
        int n = sc.nextInt();          
        int[] Arr = new int[n];
        for (int i = 0; i < n; i++) {
            System.out.print(": ");
            Arr[i] = sc.nextInt();     
        }

        int[] result = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= Arr[i]) {
                stack.pop();
            }
            if (stack.isEmpty()) result[i] = -1;
            else result[i] = stack.peek();
            stack.push(Arr[i]);
        }

        for (int i = 0; i < n; i++) {
            System.out.print(result[i] + " ");
        }
        sc.close();
    }
}
