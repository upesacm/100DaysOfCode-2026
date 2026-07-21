package Day_34;

import java.util.*;

public class d34question2_technical {
    public static int maxPeopleVisible(int[] arr) {
        int n = arr.length;

        int[] L = new int[n];
        int[] R = new int[n];

        Stack<Integer> stack = new Stack<>();

        // Nearest greater or equal on the L
        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            L[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(i);
        }

        stack.clear();

        // Nearest greater or equal on the R
        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }

            R[i] = stack.isEmpty() ? n : stack.peek();
            stack.push(i);
        }

        int maxVisible = 0;

        for (int i = 0; i < n; i++) {
            int visible = R[i] - L[i] - 1; // includes self
            maxVisible = Math.max(maxVisible, visible);
        }

        return maxVisible;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter Size of Array: ");
        int n = sc.nextInt();
        int[] Arr = new int[n];
        for(int i=0;i<n;i++){
            System.out.print(": ");
            Arr[i]=sc.nextInt();
        }

        System.out.println(maxPeopleVisible(Arr));
        sc.close();}
    }
