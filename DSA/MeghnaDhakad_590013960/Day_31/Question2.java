import java.util.Arrays;

public class Question2 {

    public static int[] nextGreaterElement(int[] arr) {
        int n = arr.length;

        int[] ans = new int[n];
        int[] stack = new int[n];

        int top = -1;

        for (int i = n - 1; i >= 0; i--) {

            while (top >= 0 && stack[top] <= arr[i]) {
                top--;
            }

            if (top == -1) {
                ans[i] = -1;
            } else {
                ans[i] = stack[top];
            }

            stack[++top] = arr[i];
        }

        return ans;
    }

    public static void main(String[] args) {
        int[] arr = {1, 3, 2, 4};

        System.out.println(
            Arrays.toString(nextGreaterElement(arr))
        );
    }
}