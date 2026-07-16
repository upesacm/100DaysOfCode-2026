import java.util.Arrays;
import java.util.Stack;

public class Question2 {
    public static int[] NextGreater(int[] arr){
        int n = arr.length;
        Stack<Integer> s = new Stack<>();
        int[] ans = new int[n];

        for(int i = n - 1; i >= 0 ; i--){
            while(!s.isEmpty() && s.peek() <= arr[i]){
                s.pop();
            }
        if(s.empty()){
            ans[i] = -1;
        }else{
            ans[i] = s.peek();
        }
        s.push(arr[i]);
    }
    return ans;
}
    public static void main(String[] args){
        int arr[] = {1,3,2,4};
        int[] ans = NextGreater(arr);
        System.out.println(Arrays.toString(ans));
    }
}