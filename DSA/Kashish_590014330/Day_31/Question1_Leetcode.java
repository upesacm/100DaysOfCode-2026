import java.util.Scanner;
import java.util.Stack;

public class Question1_Leetcode {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size:");
        int size=sc.nextInt();
        int arr[]=new int[size];
        int ans[]=new int[arr.length];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        
        Stack<Integer> st=new Stack<>();
        for(int i=arr.length-1;i>=0;i--){
            while(st.size()!=0 && st.peek()> arr[i]){
                st.pop();
            }
           if (!st.isEmpty()) {
                ans[i] = arr[i];
            }
            else{
                ans[i] = arr[i] - st.peek();
            }
            st.push(arr[i]);

        }
        for (int i=0;i<ans.length;i++){
            System.out.println(ans[i]+" ");
        }
        sc.close();

       
    }
    }
    

