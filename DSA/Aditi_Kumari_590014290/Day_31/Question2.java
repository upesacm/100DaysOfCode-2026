/*Next Greater Element in Array
Explanation
Given an array of integers, find the first greater element on the right for every element; if no greater element exists, return -1.

Example
Input:arr[] = [1,3,2,4]. Output:[3,4,4,-1] */
package Day_31;
import java.util.Stack;
public class Question2 {
    public int[] NextGreater(int []arr){
        Stack<Integer> stack=new Stack<>();
        int []ans=new int [arr.length];
        for (int i=arr.length; i>=0; i--){
            while (!stack.isEmpty() && stack.peek() < arr[i]){
                stack.pop();
            }
            if (stack.isEmpty()){
                ans[i]=-1;
            }
            else{
                ans[i]=stack.peek();
            }
            stack.push(arr[i]);
        }
        return ans;
    }
}
