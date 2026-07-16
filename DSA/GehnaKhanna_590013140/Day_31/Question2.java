import java.util.*;

class Solution {
    public int[] nextGreater(int[] arr) {

        int n = arr.length;
        int[] ans = new int[n];
        Arrays.fill(ans, -1);

        Stack<Integer> stack = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!stack.isEmpty() &&
                    arr[i] > arr[stack.peek()]) {

                ans[stack.peek()] = arr[i];
                stack.pop();
            }

            stack.push(i);
        }

        return ans;
    }
}
