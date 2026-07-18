
import java.util.*;
class MP{
    public static void main(String[] args){
        int[] arr = {6, 2, 5, 4, 5, 1, 6};
        int n = arr.length;
        int[] left = new int[n];
        int[] right = new int[n];
        Stack<Integer> st = new Stack<>();
        for(int i = 0; i < n; i++) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty())
                left[i] = -1;
            else
                left[i] = st.peek();
            st.push(i);
        }
        st.clear();
        for (int i = n - 1; i >= 0; i--) {
            while (!st.isEmpty() && arr[st.peek()] >= arr[i]) {
                st.pop();
            }
            if (st.isEmpty())
                right[i] = n;
            else
                right[i] = st.peek();
            st.push(i);
        }
        int maxVisible = 0;
        for (int i = 0; i < n; i++) {
            int width = right[i] - left[i] - 1;
            maxVisible = Math.max(maxVisible, width);
        }
        System.out.println("Maximum People Visible: " + maxVisible);
    }
}