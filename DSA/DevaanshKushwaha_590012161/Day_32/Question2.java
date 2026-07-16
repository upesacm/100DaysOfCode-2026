import java.util.*;

class Solution {
    public Stack<Integer> copyStack(Stack<Integer> st) {
        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();
        
        // Step 1: Reverse st into temp (empties st)
        while (!st.isEmpty()) {
            temp.push(st.pop());
        }
        
        // Step 2: Reverse temp back into both st (restore) and copy (destination)
        while (!temp.isEmpty()) {
            int val = temp.pop();
            st.push(val);    // restore original stack
            copy.push(val);  // build the copy in the same order
        }
        
        return copy;
    }
    
    public static void main(String[] args) {
        Stack<Integer> st = new Stack<>();
        for (int val : new int[]{1, 2, 3, 4}) st.push(val);
        
        Solution sol = new Solution();
        Stack<Integer> copy = sol.copyStack(st);
        
        System.out.println(copy);  // prints bottom->top: [1, 2, 3, 4]
        System.out.println(st);    // original st unchanged: [1, 2, 3, 4]
    }
}
