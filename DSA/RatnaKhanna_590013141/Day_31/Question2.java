import java.util.Stack;

class Solution {
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] ans = new int[n];

        for (int i = 0; i < n; i++) {
            ans[i] = -1;
        }

        Stack<Integer> st = new Stack<>();

        for (int i = 0; i < n; i++) {

            while (!st.isEmpty() && arr[i] > arr[st.peek()]) {
                ans[st.peek()] = arr[i];
                st.pop();
            }

            st.push(i);
        }

        return ans;
    }
}
