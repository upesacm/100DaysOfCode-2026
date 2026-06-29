public class Question2{
    public static void main(String[] args){
        Solution obj = new Solution();
        String s = "Computer";
        String result = obj.reverseString(s);
        System.out.println(result);
    }
}
class Solution{
    public String reverseString(String s){
        char[] arr = s.toCharArray();
        
        int st = 0;
        int end = arr.length - 1;
        while(st < end){
            char temp = arr[st];
            arr[st] = arr[end];
            arr[end] = temp;

            st++;
            end--;
        }
        return new String(arr);
    }
}