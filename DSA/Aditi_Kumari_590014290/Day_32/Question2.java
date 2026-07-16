/*Copy all elements from one stack to another while preserving the original order using only stack operations, and print the copied stack.

Example
Input:st = [1,2,3,4]. Output:[1,2,3,4] */

package Day_32;

import java.util.Stack;

public class Question2 {
    public static Stack<Integer> copyStack(Stack<Integer> original) {

        Stack<Integer> temp = new Stack<>();
        Stack<Integer> copy = new Stack<>();
        while (!original.isEmpty()) {
            temp.push(original.pop());
        }
        while (!temp.isEmpty()) {
            int x = temp.pop();
            original.push(x);
            copy.push(x);
        }

        return copy;
    }
}
