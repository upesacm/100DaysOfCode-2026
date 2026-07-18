import java.util.*;

class Solution {
    public int maxPeopleVisible(int[] arr) {
        int n = arr.length;

        int[] left = new int[n];
        int[] right = new int[n];

        Stack<Integer> st = new Stack<>();

        // Nearest greater or equal on the left
        for (int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            left[i] = st.isEmpty() ? -1 : st.peek();
            st.push(i);
        }

        st.clear();

        // Nearest greater or equal on the right
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] < arr[i]) {
                st.pop();
            }

            right[i] = st.isEmpty() ? n : st.peek();
            st.push(i);
        }

        int maxVisible = 0;

        for (int i = 0; i < n; i++) {
            int visible = right[i] - left[i] - 1; // includes self
            maxVisible = Math.max(maxVisible, visible);
        }

        return maxVisible;
    }
}
