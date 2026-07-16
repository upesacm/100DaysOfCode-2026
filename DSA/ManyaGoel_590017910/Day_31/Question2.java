import java.util.*;
public class Question2 {
    public static int[] nextGreater( int[] arr){
        Stack <Integer> stack = new Stack<>();
        int n = arr.length;
        int[] result =  new int[n];
        Arrays.fill(result,-1);
        for (int i = n - 1; i >= 0; i--) {
            // Remove all smaller or equal elements
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            // If stack is not empty, top is the next greater element
            if (!stack.isEmpty()) {
                result[i] = stack.peek();
            }
            // Push current element
            stack.push(arr[i]);
        }
        return result;
    }
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        System.out.print("Enter the size of the array: ");
        int n = sc.nextInt();
        int[] arr = new int[n];
        System.out.println("Enter the array elements:");
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }
        int[] ans = nextGreater(arr);
        System.out.println("Next Greater Elements:");
        System.out.print("[");
        for (int i = 0; i < ans.length; i++) {
            System.out.print(ans[i]);
        if (i != ans.length - 1) {
            System.out.print(" ");
        }
    }
    System.out.println("]");
        sc.close();
    }
}