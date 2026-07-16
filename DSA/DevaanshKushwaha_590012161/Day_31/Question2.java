import java.util.*;

class Solution {
    public int[] nextGreaterElement(int[] arr) {
        int n = arr.length;
        int[] answer = new int[n];
        Deque<Integer> stack = new ArrayDeque<>(); // holds candidate values, decreasing bottom->top
        
        for (int i = n - 1; i >= 0; i--) {
            // Discard values that can't be the answer for arr[i] or anything left of it
            while (!stack.isEmpty() && stack.peek() <= arr[i]) {
                stack.pop();
            }
            
            // Top of stack (if any) is the nearest greater element to the right
            answer[i] = stack.isEmpty() ? -1 : stack.peek();
            
            // Current element becomes a candidate for elements to its left
            stack.push(arr[i]);
        }
        
        return answer;
    }
    
    public static void main(String[] args) {
        Solution sol = new Solution();
        int[] arr = {1, 3, 2, 4};
        System.out.println(Arrays.toString(sol.nextGreaterElement(arr)));
    }
}
