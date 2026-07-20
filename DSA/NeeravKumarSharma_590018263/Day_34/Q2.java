import java.util.Stack;

public class Q2 {

    public static int maxVisible(int[] arr) {
        int n = arr.length;
        int[] leftLimit = new int[n];
        int[] rightLimit = new int[n];
        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            int prevGreaterIndex = stack.isEmpty() ? -1 : stack.peek();
            leftLimit[i] = i - prevGreaterIndex - 1; 
            stack.push(i);
        }

        stack.clear();

        for (int i = n - 1; i >= 0; i--) {
            while (!stack.isEmpty() && arr[stack.peek()] < arr[i]) {
                stack.pop();
            }
            int nextGreaterIndex = stack.isEmpty() ? n : stack.peek();
            rightLimit[i] = nextGreaterIndex - i - 1; 
            stack.push(i);
        }
        int maxCount = 0;
        for (int i = 0; i < n; i++) {
            int totalVisible = leftLimit[i] + rightLimit[i] + 1;
            maxCount = Math.max(maxCount, totalVisible);
        }

        return maxCount;
    }

    public static void main(String[] args) {
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        System.out.println("Output: " + maxVisible(arr));
    }
}