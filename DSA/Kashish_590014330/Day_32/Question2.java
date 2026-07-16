import java.util.Scanner;
import java.util.Stack;


public class Question2 {
    public static void main(String[]args){
        Scanner sc=new Scanner(System.in);
        Stack<Integer>s1=new Stack<>();
        Stack<Integer>s2=new Stack<>();
        Stack<Integer>s3=new Stack<>();
        
        System.out.println("Enter array size:");
        int size=sc.nextInt();
        int arr[]=new int[size];
        for(int i=0;i<size;i++){
            arr[i]=sc.nextInt();
            s1.push(arr[i]);
        }
        while(!s1.isEmpty()){
            s2.push(s1.peek());
            s1.pop();
        }
        while(!s2.isEmpty()){
            s3.push(s2.peek());
            s2.pop();
        }
         System.out.println("Copied Stack: " + s3);
    }
        
    
}
