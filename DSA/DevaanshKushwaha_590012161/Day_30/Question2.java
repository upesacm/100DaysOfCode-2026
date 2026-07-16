import java.util.*;

class Solution {
    public void insertAtBottom(Stack<Integer> stack, int x) {
        // Base case: stack is empty, so this is the bottom -> push x here
        if (stack.isEmpty()) {
            stack.push(x);
            return;
        }
        
        // Remove the top element and hold onto it
        int top = stack.pop();
        
        // Recurse on the remaining (smaller) stack
        insertAtBottom(stack, x);
        
        // Restore the element we removed, now that x is placed below everything
        stack.push(top);
    }
    
    public Stack<Integer> insertAtBottomOfStack(Stack<Integer> stack, int x) {
        insertAtBottom(stack, x);
        return stack;
    }
    
    public static void main(String[] args) {
        Stack<Integer> stack = new Stack<>();
        for (int val : new int[]{1, 2, 3, 4}) stack.push(val);
        
        Solution sol = new Solution();
        sol.insertAtBottomOfStack(stack, 5);
        
        // Print bottom to top: [5, 1, 2, 3, 4]
        System.out.println(stack);
    }
}
