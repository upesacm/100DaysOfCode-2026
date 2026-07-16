import java.util.Stack;

public class Problem2 {
    public int[] nextGreaterElements(int[] arr) {
        int[] answer = new int[arr.length];
        Stack<Integer> stack = new Stack<>();

        for (int i = arr.length - 1; i >= 0; i--) {
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }

            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            stack.push(arr[i]);
        }

        return answer;
    }
}