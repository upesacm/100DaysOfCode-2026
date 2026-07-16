import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] a = new int[n];
        Stack<Integer> st = new Stack<>();

        for (int i = n - 1; i >= 0; i--) {

            while (!st.isEmpty() && st.peek() <= arr[i]) {
                st.pop();
            }

            if (st.isEmpty()) {
                a[i] = -1;
            } else {
                a[i] = st.peek();
            }

            st.push(arr[i]);
        }

        return a;
    }
}