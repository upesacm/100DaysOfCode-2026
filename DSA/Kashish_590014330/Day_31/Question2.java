import java.util.Scanner;
import java.util.Stack;

public class Question2 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        System.out.println("Enter array size:");
        int size=sc.nextInt();
        int arr[]=new int[size];
        for (int i=0;i<size;i++){
            arr[i]=sc.nextInt();
        }
        int ans[]=new int[arr.length];
        Stack<Integer> st=new Stack<>();
        for (int i=arr.length-1;i>=0;i--){
            while(st.size()!=0 && st.peek()<=arr[i]){
                st.pop();

            }
            if(st.isEmpty()){
                ans[i]=-1;

            }
            else{
                ans[i]=st.peek();
                
            }
            st.push(arr[i]);

        }
        for(int i=0;i<ans.length;i++){
            System.out.println(ans[i]);
        }
       


    }
    
}
