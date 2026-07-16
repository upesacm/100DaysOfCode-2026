import java.util.Stack;
import java.util.Arrays;

public class NextGreaterElement {

    public static void main(String[] args){

        int arr[] = {4, 5, 2, 25};
        System.out.println("Array:"+ Arrays.toString(arr));

        Stack<Integer> stack = new Stack<>();

        int ans[] = new int[arr.length];

        for (int i = arr.length - 1; i >= 0; i--) {

            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            if (stack.isEmpty()) {
                ans[i] = -1;
            } else {
                ans[i] = stack.peek();
            }

            stack.push(arr[i]);
        }

        System.out.print("Answer: ");
        for (int x : ans) {
            System.out.print(x + " ");
        }
    }
    
}
