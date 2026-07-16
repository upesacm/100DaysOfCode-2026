import java.util.ArrayDeque;
class Solution {
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] r = new int[n];
        ArrayDeque<Integer> st = new ArrayDeque<>();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && st.peek() <= arr[i]) st.pop();
            r[i] = st.isEmpty() ? -1 : st.peek();
            st.push(arr[i]);
        } return r;
    }
}