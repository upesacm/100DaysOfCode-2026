/*Insert Element at Bottom of Stack
Given a stack of integers and an integer x, insert x at the bottom of the stack while preserving the order of the remaining elements, and print the updated stack.

Example
Input:Stack = [1,2,3,4], x = 5. Output:[5,1,2,3,4] */
package Day_30;

import java.util.Stack;

public class Question2 {
    void insertAtBottom(Stack<Integer> stack,int x){
        if(stack.isEmpty()){
            stack.push(x);
            return;
        }
        int temp=stack.pop();
        insertAtBottom(stack, x);
        stack.push(temp);
    }
    
}
